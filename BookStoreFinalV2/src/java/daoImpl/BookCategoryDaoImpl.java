/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.BookCategoryDao;
import entities.BookCategory;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ngocv 
 */
public class BookCategoryDaoImpl implements BookCategoryDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<BookCategory> getAllBookCategorys() {
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
    public String getNameCategoryById(String id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from BookCategory where Id=?");
            query.setParameter(0, id);
            BookCategory cate = (BookCategory) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return cate.getName();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }
    @Override
    public BookCategory getBookCategoryById(String id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from BookCategory where Id=?");
            query.setParameter(0, id);
            BookCategory cate = (BookCategory) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return cate;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Boolean insertCategory(BookCategory cate) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(cate);
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
    public Boolean deleteCategory(String id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete from BookCategory where Id=?");
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
    public Boolean updateCategory(BookCategory cate) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(cate);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }
}
