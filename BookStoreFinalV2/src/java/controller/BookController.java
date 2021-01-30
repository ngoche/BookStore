package controller;

import dao.BookCategoryDao;
import dao.BookDao;
import dao.SearchDao;
import entities.Book;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    private SearchDao searchDao;
    private BookCategoryDao bookCategoryDao;
    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Autowired
    public void setSearchDao(SearchDao searchDao) {
        this.searchDao = searchDao;
    }

    @Autowired
    public void setBookCategoryDao(BookCategoryDao bookCategoryDao) {
        this.bookCategoryDao = bookCategoryDao;
    }

    @RequestMapping(value = "/LovelyBookDone")
    public String LovelyBookDone1(Model model, Integer offset, Integer maxResults, HttpSession session) {
        model.addAttribute("book", new Book());
        return "lovelyBook";
    }

    @RequestMapping(value = "/search")
    public String SearchBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
            model.addAttribute("book", new Book());

        List<Book> listSearch = searchDao.searchBook(book.getBookName());
        if (listSearch == null) {
            model.addAttribute("error", "Sorry! No result for your keyword");
            return "searchBook";
        } else {
//            session.setAttribute("ResultsListB", listSearch);
//            return "redirect:/resultSearchClient.htm";
            model.addAttribute("listResultB", listSearch);
            return "searchBook";
        }
    }

    @RequestMapping(value = "/hotBookDone")
    public String hotBookDone(Model model, Integer offset, Integer maxResults, HttpSession session) {
        model.addAttribute("book", new Book());
        model.addAttribute("getBookByHot", bookDao.getBookByStatus("0"));
        return "hotBook";
    }

    @RequestMapping(value = "/newBookDone")
    public String newBookDone(Model model, Integer offset, Integer maxResults, HttpSession session) {
        model.addAttribute("book", new Book());
        model.addAttribute("getBookByNew", bookDao.getBookByStatus("0"));
        return "newBook";
    }

    @RequestMapping(value = "/allBook")
    public String listBook(Model model, Integer offset, Integer maxResults, HttpSession session) {
        List<Book> list = bookDao.getBooks(offset, maxResults);
        model.addAttribute("listBook", list);
        model.addAttribute("book", new Book());
        session.setAttribute("offset", offset);
        session.setAttribute("count", bookDao.getTotalBooks());
        return "allBook";
    }

    @RequestMapping(value = "/detailBook")
    public String detailBooks(@RequestParam("isbn") Integer isbn, Model model, Integer offset, Integer maxResults, HttpSession session) {
        List<Book> list = bookDao.getBooks(offset, maxResults);
        model.addAttribute("book", new Book());
        session.setAttribute("b", bookDao.getBookByIsbn(isbn));
        return "detailBook";
    }

    @RequestMapping(value = "/getListBookByCate")
    public String getBookByCategory(@RequestParam("categoryId") String BookCategoryId, Model model, Integer offset, Integer maxResults, HttpSession session) {
        model.addAttribute("book", new Book());
        model.addAttribute("listBookByCate", bookDao.getBookByCategory(BookCategoryId));
        model.addAttribute("nameCategory", bookCategoryDao.getNameCategoryById(BookCategoryId));
        return "viewBookByCategory";
    }

    @RequestMapping(value = "/getListBookByAuthor")
    public String getBookByAuthor(@RequestParam("authorId") String AuthorId, Model model, Integer offset, Integer maxResults, HttpSession session) {
        model.addAttribute("book", new Book());
        model.addAttribute("listBookByAuthor", bookDao.getBookByAuthor(AuthorId));
        model.addAttribute("nameAuthor", bookCategoryDao.getNameCategoryById(AuthorId));
        return "viewBookByAuthor";
    }

    @RequestMapping(value = "/getListBookPublisher")
    public String getBookByPublisher(@RequestParam("publisherId") String PublisherId, Model model, Integer offset, Integer maxResults, HttpSession session) {
        model.addAttribute("book", new Book());
        model.addAttribute("listBookByPublisher", bookDao.getBookByPublisher(PublisherId));
        model.addAttribute("namePublisher", bookCategoryDao.getNameCategoryById(PublisherId));
        return "viewBookByPublisher";
    }

}
