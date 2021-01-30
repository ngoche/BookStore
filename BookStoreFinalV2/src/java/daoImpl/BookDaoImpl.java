/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.BookDao;
import entities.Author;
import entities.Book;
import entities.BookCategory;
import entities.Publisher;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ngocv
 */
public class BookDaoImpl implements BookDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Book> getBooks(Integer offset, Integer maxResults) {
        Session ss = sessionFactory.openSession();
        Criteria cr = ss.createCriteria(Book.class);
        cr.setFirstResult(offset != null ? offset : 0);
        cr.setMaxResults(maxResults != null ? maxResults : 8);
        List list = cr.list();
        return list;
    }

    @Override
    public long getTotalBooks() {
        return (Long) sessionFactory.openSession()
                .createCriteria(Book.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    @Override
    public Book getBookByIsbn(Integer isbn) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Book where Isbn=?");
            query.setParameter(0, isbn);
            Book b = (Book) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getBookByCategory(String BookCategoryId) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query qr = session.createQuery("from Book where BookCategoryId=?");
            qr.setParameter(0, BookCategoryId);
            List<Book> listB = qr.list();
            session.getTransaction().commit();
            session.close();
            return listB;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public boolean updateBook(Book book) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean insertBook(Book book) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
//            session.saveOrUpdate(book);
            session.persist(book);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean deleteBook(String id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete from Book where Isbn=?");
            query.setParameter(0, id);
            int i = query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Book> getBookByStatus(String Status) {
        Session ss = sessionFactory.openSession();
        List<Book> listB = new ArrayList<>();
        try {
            ss.beginTransaction();
            Query qr = ss.createQuery("from Book where Status=?");
            qr.setParameter(0, Status);
            listB = (List<Book>) qr.list();
            ss.getTransaction().commit();
            ss.close();
            return listB;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getBookByAuthor(String authorId) {
        Session ss = sessionFactory.openSession();
        List<Book> listB = new ArrayList<>();
        try {
            ss.beginTransaction();
            Query qr = ss.createQuery("from Book where AuthorId=?");
            qr.setParameter(0, authorId);
            listB = (List<Book>) qr.list();
            ss.getTransaction().commit();
            ss.close();
            return listB;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Author> getAllAuthor() {
        try {
            Session ss = sessionFactory.openSession();
            ss.beginTransaction();
            Query qr = ss.createQuery("from Author");
            List list = qr.list();
            ss.getTransaction().commit();
            ss.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Publisher> getAllPublisher() {
        try {
            Session ss = sessionFactory.openSession();
            ss.beginTransaction();
            Query qr = ss.createQuery("from Publisher");
            List list = qr.list();
            ss.getTransaction().commit();
            ss.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getBookByPublisher(String publisherId) {
        Session ss = sessionFactory.openSession();
        List<Book> listB = new ArrayList<>();
        try {
            ss.beginTransaction();
            Query qr = ss.createQuery("from Book where PublisherId=?");
            qr.setParameter(0, publisherId);
            listB = (List<Book>) qr.list();
            ss.getTransaction().commit();
            ss.close();
            return listB;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BookCategory> getAllCategory() {
        try {
            Session ss = sessionFactory.openSession();
            ss.beginTransaction();
            Query qr = ss.createQuery("from BookCategory");
            List list = qr.list();
            ss.getTransaction().commit();
            ss.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        try {
            Session ss = sessionFactory.openSession();
            ss.beginTransaction();
            Query qr = ss.createQuery("from Book");
            List list = qr.list();
            ss.getTransaction().commit();
            ss.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
