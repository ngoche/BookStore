/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bookstore.model.AccountLogin;
import dao.BookDao;
import dao.PayDao;
import entities.Account;
import entities.Book;
import bookstore.model.BookCart;
import bookstore.model.PaymentInfo;
import entities.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CostomerAccount;

/**
 *
 * @author ngocv
 */
@Controller
public class CheckOutController implements Serializable {

    private BookDao bookDao;
    private PayDao payDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Autowired
    public void setPayDao(PayDao payDao) {
        this.payDao = payDao;
    }

    @RequestMapping(value = "/CheckOutCart")
    public String prepareCheckOut(Model model, HttpSession session, Integer offset, Integer maxResults) {
            model.addAttribute("book", new Book());

        model.addAttribute("paymentInfo", new PaymentInfo());
//        }
        model.addAttribute("book", new Book());
        return "checkOut";
    }

    @RequestMapping(value = "/CheckOutProcess", method = RequestMethod.POST)
    public String doCheckOut( @ModelAttribute("paymentInfo") PaymentInfo paymentInfo, Model model, HttpSession session, Integer offset, Integer maxResults) {
        model.addAttribute("book", new Book());
        Map<Integer, Integer> listBookBuy = (Map<Integer, Integer>) session.getAttribute("listBookBuy");
        if (session.getAttribute("isLogin") != null) {
            List<BookCart> listBuy = new ArrayList<>();
            List<Book> allBooks = bookDao.getBooks(offset, maxResults);
            float totalPaid = 0;
            for (Map.Entry<Integer, Integer> books : listBookBuy.entrySet()) {
                BookCart objB = new BookCart();
                objB.setIsbn(books.getKey());
                for (Book b : allBooks) {
                    if (b.getIsbn().equals(objB.getIsbn())) {
                        objB.setBookName(b.getBookName());
                        objB.setAuthorId(b.getAuthorId());
                        objB.setDescription(b.getDescription());
                        objB.setPrice(b.getPrice());
                        objB.setPictureThumb(b.getPictureThumb());
                        objB.setNumberOfBook(books.getValue());
                        objB.setTotalPrice(b.getPrice() * objB.getNumberOfBook());
                        listBuy.add(objB);
                        totalPaid = totalPaid + objB.getTotalPrice();
                        break;
                    }
                }
            }
            model.addAttribute("totalPaid", totalPaid);
            model.addAttribute("listBookBy", listBuy);
            model.addAttribute("paymentInfo", new PaymentInfo());
            CostomerAccount acc = checkAccount(paymentInfo.getAccountName(), paymentInfo.getPassword());
            if (acc == null) {
                model.addAttribute("paymentStatus", "Your account is incorrect !");
            } else {
                boolean blCheckBalance = checkBalance(acc, totalPaid);
                if (!blCheckBalance) {
                    model.addAttribute("paymentStatus", "Not enought money!");
                    return "checkOut";
                } else {
                    paymentInfo.setWebId(1);
                    boolean blPayment = payment(acc, totalPaid, paymentInfo.getWebId());
                    if (!blPayment) {
                        model.addAttribute("paymentStatus", "Error occured while checking out!");
                        return "checkOut";
                    } else {
                        model.addAttribute("paymentStatus", "You've got successfully paying, We'll contact to you soon, Thanks for that!");
                        Account a = (Account) session.getAttribute("acc");
                        Customer customer = a.getCustomerId();
                        BookCart b = new BookCart();
                        b.setList(listBuy);
                        payDao.saveOrderInfo(customer, b);

                        session.setAttribute("listBookBuy", null);
                        return "successfullyPaid";
                    }
                }
            }
            return "checkOut";

        } else {
            model.addAttribute("status", "You need to login first!");
            model.addAttribute("acclogin", new AccountLogin());
            return "login";
        }
    }

    private static CostomerAccount checkAccount(java.lang.String accountName, java.lang.String password) {
        service.BankService_Service service = new service.BankService_Service();
        service.BankService port = service.getBankServicePort();
        return port.checkAccount(accountName, password);
    }

    private static boolean checkBalance(service.CostomerAccount acc, float moneyToPaid) {
        service.BankService_Service service = new service.BankService_Service();
        service.BankService port = service.getBankServicePort();
        return port.checkBalance(acc, moneyToPaid);
    }

    private static boolean payment(service.CostomerAccount accPaid, float moneyToPaid, int webId) {
        service.BankService_Service service = new service.BankService_Service();
        service.BankService port = service.getBankServicePort();
        return port.payment(accPaid, moneyToPaid, webId);
    }

}
