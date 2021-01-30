/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Author;
import entities.Book;
import entities.BookCategory;
import entities.Publisher;
import java.util.List;

/**
 *
 * @author ngocv
 */
public interface BookDao {

    public List<Book> getBooks(Integer offset, Integer maxResults);// get List Books và để phân trang

    public List<Book> getAllBooks();

    public long getTotalBooks();// để phân trang

    public List<Book> getBookByCategory(String BookCategoryId);//xem theo thể loại

    public List<Book> getBookByAuthor(String authorId);

    public Book getBookByIsbn(Integer isbn);// detail

    public boolean updateBook(Book book);

    public boolean insertBook(Book book);

    public boolean deleteBook(String id);

    public List<Book> getBookByStatus(String Status);

    public List<Author> getAllAuthor();

    public List<Publisher> getAllPublisher();

    public List<BookCategory> getAllCategory();

    public List<Book> getBookByPublisher(String publisherId);

}
