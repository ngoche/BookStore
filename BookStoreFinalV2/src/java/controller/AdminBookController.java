package controller;

import bookstore.model.BookToInsert;
import dao.AuthorDao;
import dao.BookCategoryDao;
import dao.BookDao;
import dao.PublisherDao;
import dao.SearchDao;
import entities.Author;
import entities.Book;
import entities.BookCategory;
import entities.Publisher;
import java.io.Serializable;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminBookController implements Serializable {

    private SearchDao searchDao;
    private BookDao bookDAO;
    private BookCategoryDao bookCategoryDAO;
    private AuthorDao authorDAO;
    private PublisherDao publisherDAO;

    @Autowired
    public void setSearchDao(SearchDao searchDao) {
        this.searchDao = searchDao;
    }

    @Autowired
    public void setBookDao(BookDao bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Autowired
    public void setAuthorDao(AuthorDao authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Autowired
    public void setBookCategoryDao(BookCategoryDao bookCategoryDAO) {
        this.bookCategoryDAO = bookCategoryDAO;
    }

    @Autowired
    public void setPublisherDao(PublisherDao publisherDAO) {
        this.publisherDAO = publisherDAO;
    }

    @RequestMapping(value = "/adminBack")
    public String adminBack(HttpSession session) {
        return "admin";
    }

    @RequestMapping(value = "/requestLogin")
    public String requestLogin(HttpSession session) {
        return "error";
    }

    @RequestMapping(value = "/searchBookAdmin")
    public String SearchBookAdmin(@ModelAttribute("book") Book book, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            List<Book> listSearch = null;
            if (book.getStatus() == 0) {
                listSearch = searchDao.searchBook(book.getBookName());
            } else if (book.getStatus() == 1) {
                listSearch = searchDao.searchBookByCategory(book.getBookName());
            } else if (book.getStatus() == 2) {
                listSearch = searchDao.searchBookByAuthor(book.getBookName());
            } else if (book.getStatus() == 3) {
                listSearch = searchDao.searchBookByPublisher(book.getBookName());
            } else {
                listSearch = null;
            }

            if (listSearch == null) {
                model.addAttribute("book", new Book());
                model.addAttribute("error", "Không có dữ liệu nào trong csdl");
                return "redirect:/listB.htm";
            } else {
                session.setAttribute("ResultsListB", listSearch);
//                return "searchBookAdmin";
                return "redirect:/resultSearch.htm";
            }
        } else {
            return "redirect:/requestLogin.htm";
        }
    }
    @RequestMapping(value = "/resultSearch")
    public String resultSearch(Model model, Integer offset, Integer maxResults, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            List<Book> list = (List<Book>) session.getAttribute("ResultsListB");
            model.addAttribute("listResult",searchDao.resultSearchBook(list, offset, maxResults));
            model.addAttribute("offset", offset);
            model.addAttribute("count", list.size());
            model.addAttribute("book", new Book());
            return "resultSearch";
        }
            return "redirect:/requestLogin.htm";
    }

    //Book     //Book     //Book     //Book    //Book    //Book
    //Book     //Book     //Book     //Book    //Book    //Book
    //Book     //Book     //Book     //Book    //Book    //Book
    //Book     //Book     //Book     //Book    //Book    //Book
    //Book     //Book     //Book     //Book    //Book    //Book
    //Book     //Book     //Book     //Book    //Book    //Book
    @RequestMapping(value = "/listB")
    public String loadAllBooks(Model model, Integer offset, Integer maxResults, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            session.setAttribute("listBook", bookDAO.getBooks(offset, maxResults));
            session.setAttribute("offset", offset);
            session.setAttribute("count", bookDAO.getTotalBooks());
            model.addAttribute("book", new Book());
            session.setAttribute("listAuthor", authorDAO.getAllAuthors());
            session.setAttribute("listPublisher", publisherDAO.getAllPublishers());
            session.setAttribute("listCategory", bookCategoryDAO.getAllBookCategorys());
            return "bookManagement";
        } else {
            return "redirect:/requestLogin.htm";
        }
    }

    @RequestMapping(value = "/detailB")
    public String loadDetailBook(@RequestParam("isbn") Integer isbn, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            model.addAttribute("book", bookDAO.getBookByIsbn(isbn));
            return "bookDetail";
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/preUpdateB")
    public String initUpdateBook(@RequestParam("isbn") Integer isbn, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            Book book = bookDAO.getBookByIsbn(isbn);
            model.addAttribute("book", book);
            return "updateBook";
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public String updateBook(@Valid @ModelAttribute("book") BookToInsert book, BindingResult result, Model model, Integer offset, Integer maxResults, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            if (result.hasErrors()) {
                model.addAttribute("updateBookErr", "An error has occured!");
                model.addAttribute("book", book);
                return "updateBook";
            } else {
                Book b = new Book();
                b.setIsbn(book.getIsbn());
                b.setBookName(book.getBookName());
                b.setPrice(book.getPrice());
                b.setDiscount(book.getDiscount());
                b.setPublishYear(book.getPublishYear());
                b.setStatus(book.getStatus());
                b.setTotalPage(book.getTotalPage());
                b.setPictureThumb(book.getPictureThumb());
                b.setDescription(book.getDescription());
                b.setLanguage(book.getLanguage());

                BookCategory category = new BookCategory(book.getBookCategoryId());
                b.setBookCategoryId(category);

                Author author = new Author(book.getAuthorId());
                b.setAuthorId(author);

                Publisher publisher = new Publisher(book.getPublisherId());
                b.setPublisherId(publisher);

                boolean blUpdate = bookDAO.updateBook(b);
                if (blUpdate) {
                    model.addAttribute("Status", "Update successfully has id:" + b.getIsbn());
                    session.setAttribute("listBook", bookDAO.getBooks(offset, maxResults));
                    return "bookManagement";
                } else {
                    model.addAttribute("Status", "Update failed has id:" + b.getIsbn());
                    model.addAttribute("book", book);
                    return "updateBook";
                }
            }
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/initInsertB")
    public String initInsertBook(Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            model.addAttribute("book", new BookToInsert());
            return "insertBook";
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/insertBook", method = RequestMethod.POST)
    public String insertBook(@Valid @ModelAttribute("book") BookToInsert book, BindingResult result, Model model, Integer offset, Integer maxResults, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            if (result.hasErrors()) {
                model.addAttribute("updateBookErr", "An error has occured!");
                model.addAttribute("book", book);
                model.addAttribute("Status", "Add failed");
                return "insertBook";
            } else {
                Book b = new Book();
//        b.setIsbn(book.getIsbn());
                b.setBookName(book.getBookName());
                b.setPrice(book.getPrice());
                b.setDiscount(book.getDiscount());
                b.setPublishYear(book.getPublishYear());
                b.setStatus(book.getStatus());
                b.setTotalPage(book.getTotalPage());
                b.setPictureThumb(book.getPictureThumb());
                b.setDescription(book.getDescription());
                b.setLanguage(book.getLanguage());

                BookCategory category = new BookCategory(book.getBookCategoryId());
                b.setBookCategoryId(category);

                Author author = new Author(book.getAuthorId());
                b.setAuthorId(author);

                Publisher publisher = new Publisher(book.getPublisherId());
                b.setPublisherId(publisher);

                boolean blInsert = bookDAO.insertBook(b);
                if (blInsert) {
                    model.addAttribute("Status", "Add successfully for book has id:" + b.getIsbn());
                    session.setAttribute("listBook", bookDAO.getBooks(offset, maxResults));
                    return "bookManagement";
                } else {
                    model.addAttribute("Status", "Add failed");
                    model.addAttribute("book", book);
                    return "insertBook";
                }
            }
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/deleteB")
    public String deletePro(@RequestParam("isbn") String isbn, Model model, Integer offset, Integer maxResults, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            boolean blDelete = bookDAO.deleteBook(isbn);
            if (blDelete) {
                model.addAttribute("Status", "Remove successfully for book has id:" + isbn);
            } else {
                model.addAttribute("Status", "Remove failed for book has id:" + isbn);
            }
            session.setAttribute("listBook", bookDAO.getBooks(offset, maxResults));
            return "bookManagement";
        }
        return "redirect:/requestLogin.htm";
    }

    // Book caterogy    // Book caterogy    // Book caterogy    // Book caterogy
    // Book caterogy    // Book caterogy    // Book caterogy    // Book caterogy
    // Book caterogy    // Book caterogy    // Book caterogy    // Book caterogy
    // Book caterogy    // Book caterogy    // Book caterogy    // Book caterogy
    // Book caterogy    // Book caterogy    // Book caterogy    // Book caterogy
    // Book caterogy    // Book caterogy    // Book caterogy    // Book caterogy
    // Book caterogy    // Book caterogy    // Book caterogy    // Book caterogy
    // Book caterogy    // Book caterogy    // Book caterogy    // Book caterogy
    @RequestMapping(value = "/listCate")
    public String loadAllCategory(Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            session.setAttribute("listCategory", bookCategoryDAO.getAllBookCategorys());
            return "bookCategoriesManagement";
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/preUpdateCate")
    public String initUpdateCate(@RequestParam("id") String id, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            BookCategory cate = bookCategoryDAO.getBookCategoryById(id);
            model.addAttribute("cate", cate);
            return "updateCategory";
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/updateCate", method = RequestMethod.POST)
    public String updateCate(@Valid @ModelAttribute("cate") BookCategory cate, BindingResult result, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            if (result.hasErrors()) {
                model.addAttribute("updateCateErr", "An error has occured!");
                model.addAttribute("cate", cate);
                model.addAttribute("Status", "Update failed has id:" + cate.getId());
                return "updateCategory";
            } else {
                BookCategory c = new BookCategory();
                c.setId(cate.getId());
                c.setName(cate.getName());
                boolean blUpdate = bookCategoryDAO.updateCategory(c);
                if (blUpdate) {
                    model.addAttribute("Status", "Update successfully has id:" + cate.getId());
                    session.setAttribute("listCategory", bookCategoryDAO.getAllBookCategorys());
                    return "bookCategoriesManagement";
                } else {
                    model.addAttribute("Status", "Update failed has id:" + cate.getId());
                    session.setAttribute("listCategory", bookCategoryDAO.getAllBookCategorys());
                    return "updateCategory";
                }
            }
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/initInsertCate")
    public String initInsertCate(Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            model.addAttribute("cate", new BookCategory());
            return "insertCategory";
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/insertCate", method = RequestMethod.POST)
    public String insertCate(@Valid @ModelAttribute("cate") BookCategory cate, BindingResult result, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            if (result.hasErrors()) {
                model.addAttribute("Status", "Add failed");
                model.addAttribute("cate", cate);
                return "insertCategory";
            } else {
                boolean blInsert = bookCategoryDAO.insertCategory(cate);
                if (blInsert) {
                    model.addAttribute("Status", "Add successfully for book has id:" + cate.getId());
                    session.setAttribute("listCategory", bookCategoryDAO.getAllBookCategorys());
                    return "bookCategoriesManagement";
                } else {
                    model.addAttribute("Status", "Add failed");
                    model.addAttribute("cate", cate);
                    return "insertCategory";
                }
            }
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/deleteCate")
    public String deleteCate(@RequestParam("id") String id, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            boolean blDelete = bookCategoryDAO.deleteCategory(id);
            if (blDelete) {
                model.addAttribute("Status", "Remove successfully for book has id:" + id);
            } else {
                model.addAttribute("Status", "Remove failed! id= " + id + "!Có thể còn sách có thể loại này,Hãy xóa sách đó đi");
            }
            session.setAttribute("listCategory", bookCategoryDAO.getAllBookCategorys());
            return "bookCategoriesManagement";
        }
        return "redirect:/requestLogin.htm";
    }

    // Author     // Author     // Author     // Author     // Author
    // Author     // Author     // Author     // Author     // Author
    // Author     // Author     // Author     // Author     // Author
    // Author     // Author     // Author     // Author     // Author
    // Author     // Author     // Author     // Author     // Author
    // Author     // Author     // Author     // Author     // Author
    // Author     // Author     // Author     // Author     // Author
    // Author     // Author     // Author     // Author     // Author
    @RequestMapping(value = "/listAuthor")
    public String loadAllAuthor(Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            session.setAttribute("listAuthor", authorDAO.getAllAuthors());
            return "authorManagement";
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/preUpdateAuthor")
    public String initUpdateAuthor(@RequestParam("id") String id, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            Author author = authorDAO.getAuthorById(id);
            model.addAttribute("author", author);
            return "updateAuthor";
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/updateAuthor", method = RequestMethod.POST)
    public String updateAuthor(@Valid @ModelAttribute("author") Author author, BindingResult result, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            if (result.hasErrors()) {
                model.addAttribute("author", author);
                model.addAttribute("Status", "Update failed has id:" + author.getId());
                return "updateAuthor";
            } else {
                boolean blUpdate = authorDAO.updateAuthor(author);
                if (blUpdate) {
                    model.addAttribute("Status", "Update successfully has id:" + author.getId());
                    session.setAttribute("listAuthor", authorDAO.getAllAuthors());
                    return "authorManagement";
                } else {
                    model.addAttribute("Status", "Update failed has id:" + author.getId());
                    session.setAttribute("listCategory", authorDAO.getAllAuthors());
                    return "updateAuthor";
                }
            }
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/initInsertAuthor")
    public String initInsertAuthor(Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            model.addAttribute("author", new Author());
            return "insertAuthor";
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/insertAuthor", method = RequestMethod.POST)
    public String insertAuthor(@Valid @ModelAttribute("author") Author author, BindingResult result, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            if (result.hasErrors()) {
                model.addAttribute("Status", "Add failed");
                model.addAttribute("author", author);
                return "insertAuthor";
            } else {
                boolean blInsert = authorDAO.insertAuthor(author);
                if (blInsert) {
                    model.addAttribute("Status", "Add successfully for author has id:" + author.getId());

                    session.setAttribute("listAuthor", authorDAO.getAllAuthors());
                    return "authorManagement";
                } else {
                    model.addAttribute("Status", "Add failed");
                    model.addAttribute("author", author);
                    return "insertAuthor";
                }
            }
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/deleteAuthor")
    public String deleteAuthor(@RequestParam("id") String id, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            Author author = authorDAO.getAuthorById(id);
            boolean blDelete = authorDAO.deleteAuthor(id);
            if (blDelete) {
                session.setAttribute("Status", "Remove successfully for author has name:" + author.getName());
            } else {
                System.out.println("Helllloo lahaal asdhladf asdhfaldsf ahfasdhf ");
                session.setAttribute("Status", "Remove failed!Có thể còn sách có tác giả " + author.getName() + ", Hãy xóa sách đó đi");
            }
            model.addAttribute("listAuthor", authorDAO.getAllAuthors());
            return "authorManagement";
        }
        return "redirect:/requestLogin.htm";
    }

    //Publisher   //Publisher   //Publisher   //Publisher  //Publisher  //Publisher 
    //Publisher   //Publisher   //Publisher   //Publisher  //Publisher  //Publisher 
    //Publisher   //Publisher   //Publisher   //Publisher  //Publisher  //Publisher 
    //Publisher   //Publisher   //Publisher   //Publisher  //Publisher  //Publisher 
    //Publisher   //Publisher   //Publisher   //Publisher  //Publisher  //Publisher 
    //Publisher   //Publisher   //Publisher   //Publisher  //Publisher  //Publisher 
    //Publisher   //Publisher   //Publisher   //Publisher  //Publisher  //Publisher 
    //Publisher   //Publisher   //Publisher   //Publisher  //Publisher  //Publisher 
    @RequestMapping(value = "/listPubisher")
    public String loadAllPublisher(Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            session.setAttribute("listPublisher", publisherDAO.getAllPublishers());
            return "publisherManagement";
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/preUpdatePublisher")
    public String initUpdatePublisher(@RequestParam("id") String id, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            Publisher publisher = publisherDAO.getPublisherById(id);
            model.addAttribute("publisher", publisher);
            return "updatePublisher";
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/updatePublisher", method = RequestMethod.POST)
    public String updatePublisher(@Valid @ModelAttribute("publisher") Publisher publisher, BindingResult result, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            if (result.hasErrors()) {
                model.addAttribute("publisher", publisher);
                model.addAttribute("Status", "Update failed has id:" + publisher.getId());
                return "updatePublisher";
            } else {
                boolean blUpdate = publisherDAO.updatePublisher(publisher);
                if (blUpdate) {
                    model.addAttribute("Status", "Update successfully has id:" + publisher.getId());
                    session.setAttribute("listPublisher", publisherDAO.getAllPublishers());
                    return "publisherManagement";
                } else {
                    model.addAttribute("Status", "Update failed has id:" + publisher.getId());
                    session.setAttribute("listCategory", publisherDAO.getAllPublishers());
                    return "updatePublisher";
                }
            }
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/initInsertPublisher")
    public String initInsertPublisher(Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            model.addAttribute("publisher", new Publisher());
            return "insertPublisher";
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/insertPublisher", method = RequestMethod.POST)
    public String insertPublisher(@Valid @ModelAttribute("publisher") Publisher publisher, BindingResult result, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            if (result.hasErrors()) {
                model.addAttribute("Status", "Add failed");
                model.addAttribute("publisher", publisher);
                return "insertPublisher";
            } else {
                boolean blInsert = publisherDAO.insertPublisher(publisher);
                if (blInsert) {
                    model.addAttribute("Status", "Add successfully for publihser has id:" + publisher.getId());
                    session.setAttribute("listPublisher", publisherDAO.getAllPublishers());
                    return "publisherManagement";
                } else {
                    model.addAttribute("Status", "Add failed!");
                    model.addAttribute("publisher", publisher);
                    return "insertPublisher";
                }
            }
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/deletePublisher")
    public String deletePublisher(@RequestParam("id") String id, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            Publisher publisher = publisherDAO.getPublisherById(id);
            boolean blDelete = publisherDAO.deletePublisher(id);
            if (blDelete) {
                model.addAttribute("Status", "Remove successfully for publisher has name:" + publisher.getName());
            } else {
//             System.out.println("Helllloo lahaal asdhladf asdhfaldsf ahfasdhf ");
                model.addAttribute("Status", "Remove failed!Có thể còn sách có Nhà xuất Bản " + publisher.getName() + ", Hãy xóa sách đó đi");
            }
            session.setAttribute("listPublisher", publisherDAO.getAllPublishers());
            return "publisherManagement";
        }
        return "redirect:/requestLogin.htm";
    }

//    @RequestMapping(value = "/listB1")
//    public String loadAllbyCategory(Model model, HttpSession session) {
//        model.addAttribute("listLoadList", bookDAO.getBookByCategory("1"));
//        return "test";
//    }
//
//    @RequestMapping(value = "/searchBookByName")
//    public String findBookByName(@ModelAttribute("book") BookToInsert book, Model model, HttpSession session) {
//        book.setBookName("toàn");
//        model.addAttribute("listBookByName", bookDAO.findBookByName(book.getBookName()));
//        return "test2";
//    }
}
