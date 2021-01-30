package controller;

import bookstore.model.AccountLogin;
import dao.AccountDao;
import dao.BookCategoryDao;
import dao.BookDao;
import entities.Account;
import entities.Book;
import entities.Customer;
import bookstore.model.CustomerInfo;
import entities.CustomerType;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    private AccountDao accountDao;
    private BookCategoryDao bookCategoryDao;
    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Autowired
    public void setBookCategoryDao(BookCategoryDao bookCategoryDao) {
        this.bookCategoryDao = bookCategoryDao;
    }

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @RequestMapping(value = "/myAccountDone")
    public String showMyAccount(Model model, HttpSession session) {
        model.addAttribute("book", new Book());
        Account m = (Account) session.getAttribute("acc");
        //Account a = myAccountDao.getAccountIdByUser(m.getUserName());
        Customer c = accountDao.getData(m.getCustomerId().getId());
        CustomerInfo acc = new CustomerInfo();
        acc.setAddress(c.getAddress());
        acc.setBirthday(c.getBirthday());
        acc.setCustomerTypeId(2);
        acc.setEmail(c.getEmail());
        acc.setFullName(c.getFullName());
        acc.setGender(c.getGender());
        acc.setUsername(m.getUsername());
        acc.setPassword(m.getPassword());
        acc.setPhone(c.getPhone());
        session.setAttribute("log", acc);
        return "myAccount";
    }

    @RequestMapping(value = "/modifyInit")
    public String initUpdateProduct(@RequestParam("username") String username, HttpSession session, Model model) {
        model.addAttribute("book", new Book());
        Account a = accountDao.getAccountIdByUser(username);
        Customer c = accountDao.getData(a.getCustomerId().getId());
        CustomerInfo acc = new CustomerInfo();
        acc.setAddress(c.getAddress());
        acc.setBirthday(c.getBirthday());
        acc.setCustomerTypeId(2);
        acc.setEmail(c.getEmail());
        acc.setFullName(c.getFullName());
        acc.setGender(c.getGender());
        acc.setUsername(a.getUsername());
        acc.setPassword(a.getPassword());
        acc.setPhone(c.getPhone());
        model.addAttribute("c2info", acc);
        return "modifyAccCustomer";
    }

    @RequestMapping(value = "/doModify", method = RequestMethod.POST)
    public String modify(@Valid @ModelAttribute("c2info") CustomerInfo cinfo, HttpSession session, Model model) {
        model.addAttribute("book", new Book());
        Account account = accountDao.getAccountByUser(cinfo.getUsername());
        cinfo.setCustomerTypeId(2);

        Customer customer = new Customer();
        customer.setId(account.getCustomerId().getId());
        customer.setAddress(cinfo.getAddress());
        customer.setBirthday(cinfo.getBirthday());
        CustomerType ct = new CustomerType(cinfo.getCustomerTypeId());
        customer.setCustomerTypeId(ct);
        customer.setEmail(cinfo.getEmail());
        customer.setFullName(cinfo.getFullName());
        customer.setGender(cinfo.isGender());
        customer.setPhone(cinfo.getPhone());
        boolean blInsert = accountDao.ModifyAccount(account, customer);
        if (blInsert) {
            model.addAttribute("log", cinfo);
            return "myAccount";
        } else {
            Account accountt = (Account) session.getAttribute("acc");
            CustomerInfo cinfo2 = new CustomerInfo();
            cinfo2.setUsername(accountt.getUsername());
            cinfo2.setPassword(accountt.getPassword());
            cinfo2.setFullName(accountt.getCustomerId().getFullName());
            cinfo2.setAddress(accountt.getCustomerId().getAddress());
            cinfo2.setBirthday(accountt.getCustomerId().getBirthday());
            cinfo2.setEmail(accountt.getCustomerId().getEmail());
            cinfo2.setPhone(accountt.getCustomerId().getPhone());
            cinfo2.setGender(accountt.getCustomerId().getGender());
            cinfo2.setCustomerTypeId(accountt.getCustomerId().getCustomerTypeId().getId());
            model.addAttribute("modifyStatus", "You can't complete without full text first!");
            model.addAttribute("cinfo", cinfo2);
            return "modifyAccCustomer";
        }
    }

    @RequestMapping(value = "/deleteInit")
    public String initDeleteCustomer(Model model, HttpSession session) {
        model.addAttribute("book", new Book());

        Account a = (Account) session.getAttribute("acc");
        Customer c = a.getCustomerId();

        boolean blDeleteAccount = accountDao.DeleteAccount(a.getUsername());
        boolean blDeleteCostomer = accountDao.DeleteCostomer(c.getId());

        if (blDeleteAccount && blDeleteCostomer) {
            session.invalidate();
            return "redirect:/welcomeTest.htm";
        } else {
            return "redirect:/myAccountDone.htm";
        }
    }

}
