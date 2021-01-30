/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bookstore.model.BookCart;
import dao.BookCategoryDao;
import dao.BookDao;
import entities.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ngocv
 */
@Controller
public class BookCartController {

    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    /**
     * ******************************************************************************************
     */
    @RequestMapping(value = "/addBookToCart")
    public String addCart(@RequestParam(value = "isbn") Integer isbn, Model model, Integer offset, Integer maxResults, HttpSession session) {
        model.addAttribute("book", new Book());
        Map<Integer, Integer> listBookBuy = (Map<Integer, Integer>) session.getAttribute("listBookBuy");
        if (listBookBuy == null) {
            listBookBuy = new HashMap<>();
            listBookBuy.put(isbn, 1);
        } else {
            boolean isBought = false;
            for (Map.Entry<Integer, Integer> b : listBookBuy.entrySet()) {
                if (b.getKey().equals(isbn)) {
                    b.setValue(b.getValue() + 1);
                    isBought = true;
                    break;
                }
            }
            if (!isBought) {
                listBookBuy.put(isbn, 1);
            }
        }
        List<BookCart> listBuy = new ArrayList<>();
        List<Book> allBooks = bookDao.getAllBooks();
        float totalPaid = 0;
        for (Map.Entry<Integer, Integer> books : listBookBuy.entrySet()) {
            BookCart objB = new BookCart();
            objB.setIsbn(books.getKey());
            for (Book b : allBooks) {
                if (b.getIsbn().equals(objB.getIsbn())) {
                    objB.setBookName(b.getBookName());
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
        session.setAttribute("totalPaid", totalPaid);
        session.setAttribute("listBookBy", listBuy);
        session.setAttribute("listBookBuy", listBookBuy);
        return "index";
    }

    @RequestMapping(value = "/viewCart")
    public String showCart(HttpSession session, Model model, Integer offset, Integer maxResults) {
        model.addAttribute("book", new Book());
        return "viewCart";
    }

    @RequestMapping(value = "/deleteBookItem")
    public String deletePro(@RequestParam("isbn") Integer isbn, @ModelAttribute("book") Book book, Model model, HttpSession session) {
        Map<Integer, Integer> listBookBuy = (Map<Integer, Integer>) session.getAttribute("listBookBuy");
        for (Map.Entry<Integer, Integer> books : listBookBuy.entrySet()) {
            if (books.getKey().equals(isbn)) {
                listBookBuy.remove(isbn);
                break;
            }
        }
        List<BookCart> listBuy = new ArrayList<>();
        List<Book> allBooks = bookDao.getAllBooks();
        float totalPaid = 0;
        for (Map.Entry<Integer, Integer> books : listBookBuy.entrySet()) {
            BookCart objB = new BookCart();
            objB.setIsbn(books.getKey());
            for (Book b : allBooks) {
                if (b.getIsbn().equals(objB.getIsbn())) {
                    objB.setBookName(b.getBookName());
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
        listBookBuy = new HashMap<Integer, Integer>();
        for (BookCart bb : listBuy) {
            listBookBuy.put(bb.getIsbn(), bb.getNumberOfBook());
        }
        session.setAttribute("totalPaid", totalPaid);
        session.setAttribute("listBookBy", listBuy);
        session.setAttribute("listBookBuy", listBookBuy);
        return "redirect:/viewCart.htm";
    }

    @RequestMapping(value = "/deleteBookItemSub")
    public String deleteProSub(@RequestParam("isbn") Integer isbn, @ModelAttribute("book") Book book, Model model, HttpSession session) {
        Map<Integer, Integer> listBookBuy = (Map<Integer, Integer>) session.getAttribute("listBookBuy");
        for (Map.Entry<Integer, Integer> books : listBookBuy.entrySet()) {
            if (books.getKey().equals(isbn)) {
                listBookBuy.remove(isbn);
                break;
            }
        }List<BookCart> listBuy = new ArrayList<>();
        List<Book> allBooks = bookDao.getAllBooks();
        float totalPaid = 0;
        for (Map.Entry<Integer, Integer> books : listBookBuy.entrySet()) {
            BookCart objB = new BookCart();
            objB.setIsbn(books.getKey());
            for (Book b : allBooks) {
                if (b.getIsbn().equals(objB.getIsbn())) {
                    objB.setBookName(b.getBookName());
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
        listBookBuy = new HashMap<Integer, Integer>();
        for (BookCart bb : listBuy) {
            listBookBuy.put(bb.getIsbn(), bb.getNumberOfBook());
        }
        session.setAttribute("totalPaid", totalPaid);
        session.setAttribute("listBookBy", listBuy);
        session.setAttribute("listBookBuy", listBookBuy);
        return "redirect:/welcomeTest.htm";
    }

    @RequestMapping(value = "/updateQuality", method = RequestMethod.POST)
    public String updateQuality(HttpSession session, Integer offset, Integer maxResults, HttpServletRequest request, Model model) {
        String[] arrQuantity = request.getParameterValues("quantity");

        Map<Integer, Integer> listBookBuy = (Map<Integer, Integer>) session.getAttribute("listBookBuy");
        if (listBookBuy == null) {
            return "redirect:/welcomeTest.htm";
        } else {

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
                        break;
                    }
                }
            }

            for (int i = 0; i < arrQuantity.length; i++) {
                listBuy.get(i).setNumberOfBook(Integer.parseInt(arrQuantity[i]));
                totalPaid = totalPaid + listBuy.get(i).getPrice() * listBuy.get(i).getNumberOfBook();

            }
            session.setAttribute("totalPaid", totalPaid);
            session.setAttribute("listBookBy", listBuy);

            //cap nhat lai collection map trong gio hang voi so luong da duoc cap nhat:
            listBookBuy = new HashMap<Integer, Integer>();
            for (BookCart bb : listBuy) {
                listBookBuy.put(bb.getIsbn(), bb.getNumberOfBook());
            }
            session.setAttribute("listBookBuy", listBookBuy);
            model.addAttribute("book", new Book());
        }

        return "viewCart";
    }
}
