package controller;

import dao.BookCategoryDao;
import dao.BookDao;
import dao.LoginDao;
import entities.Account;
import bookstore.model.AccountLogin;
import entities.Book;
import bookstore.model.CustomerInfo;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import dao.EmployeeDao;
import entities.Employee;

@Controller
public class LoginController {

    private LoginDao loginDao;
    private BookDao bookDao;
    private BookCategoryDao bookCategoryDao;
    private EmployeeDao employDao;

    @Autowired
    public void setEmployDao(EmployeeDao employDao) {
        this.employDao = employDao;
    }

    @Autowired
    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Autowired
    public void setBookCategoryDao(BookCategoryDao bookCategoryDao) {
        this.bookCategoryDao = bookCategoryDao;
    }

    @RequestMapping(value = "/welcomeTest")
    public String welcomeTest(Model model, Integer offset, Integer maxResults, HttpSession session) {
        List<Book> list = bookDao.getBooks(offset, maxResults);
        model.addAttribute("book", new Book());
        session.setAttribute("listBook", list);
        session.setAttribute("offset", offset);
        session.setAttribute("count", bookDao.getTotalBooks());
        session.setAttribute("listCateT", bookCategoryDao.getAllBookCategorys());
        session.setAttribute("listAuthorT", bookDao.getAllAuthor());
        session.setAttribute("listPublisherT", bookDao.getAllPublisher());
        session.setAttribute("getBookByHot", bookDao.getBookByStatus("0"));
        session.setAttribute("getBookByNew", bookDao.getBookByStatus("0"));

        return "index";
    }

    @RequestMapping(value = "/login")
    public String loginT(Model model, Integer offset, Integer maxResults, HttpSession session) {
        model.addAttribute("book", new Book());
        model.addAttribute("acclogin", new AccountLogin());
        return "login";
    }

    @RequestMapping(value = "/loginDoneT", method = RequestMethod.POST)
    public String processLoginT(@Valid @ModelAttribute("acclogin") AccountLogin acc, BindingResult result,
            HttpSession session, Model model, Integer offset, Integer maxResults) {

        model.addAttribute("book", new Book());
        if (result.hasErrors()) {
            return "login";
        } else {
            Boolean checkEmp = loginDao.checkAdmin(acc.getUserName(), acc.getPassWord());
            if (checkEmp == true) {
                Employee emp = employDao.getEmpByUserName(acc.getUserName());
                session.setAttribute("emp", emp);
                session.setAttribute("isLogin", 1);
                return "admin";
            } else {
                Account objAcc = loginDao.getAccountByUserAndPass(acc.getUserName(), acc.getPassWord());
                if (objAcc != null) {
                    session.setAttribute("isLogin", true);
                    session.setAttribute("customer", objAcc.getCustomerId());
                    session.setAttribute("acc", objAcc);
                    return "index";
                } else {
                    model.addAttribute("loginErr", "Wrong username or password");
                    return "login";
                }
            }
        }
//        }
    }

    @RequestMapping(value = "/initRegisterT")
    public String initRegisterT(Model model, Integer offset, Integer maxResults  ) {

        model.addAttribute("book", new Book());

        CustomerInfo cinfo = new CustomerInfo();
        // Mặc định khi mới đăng ký là Loại Thường - 2
        cinfo.setCustomerTypeId(2);
        model.addAttribute("cinfo", cinfo);
        return "registerT";
    }

    @RequestMapping(value = "/doneRegisterT", method = RequestMethod.POST)
    public String processRegisterT(@Valid  @ModelAttribute("cinfo") CustomerInfo cinfo, BindingResult result,  HttpSession session, Model model  ) {
        model.addAttribute("book", new Book());
        if (result.hasErrors()) {
            model.addAttribute("registerErr", "Not complete! An error has occured!");
            return "registerT";
        } else {
            Boolean blCheck = loginDao.checkAccountExistsed(cinfo.getUsername());
            if (blCheck == true) {
                model.addAttribute("user", cinfo.getUsername());
                model.addAttribute("registerErr", "User name existed, try with another!");
                return "registerT";
            } else {
                Boolean blCreate = loginDao.createAccount(cinfo);
                if (blCreate == true) {
                    model.addAttribute("status", "Complitely register, please have login to get more experience on bookstore.com ");
                     model.addAttribute("acclogin", new AccountLogin());
                    return "login";
                } else {
                    model.addAttribute("registerErr", "An error has occured!");
                    return "registerT";
                }
            }
        }
    }

    @RequestMapping(value = "/logOut")
    public String logOutT(HttpSession session ) {
        session.invalidate();
        return "redirect:/welcomeTest.htm";
    }

}
