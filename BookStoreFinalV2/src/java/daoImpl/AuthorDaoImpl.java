/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.AuthorDao;
import entities.Author;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Admin
 */
public class AuthorDaoImpl implements AuthorDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Author> getAllAuthors() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Author");
            List<Author> list = query.list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public String getNameAuthorById(String id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Author where Id=?");
            query.setParameter(0, id);
            Author author = (Author) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return author.getName();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }
    @Override
    public Author getAuthorById(String id) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Author where Id=?");
            query.setParameter(0, id);
            Author author = (Author) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return author;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Boolean insertAuthor(Author author) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(author);
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
    public Boolean updateAuthor(Author author) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(author);
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
    public Boolean deleteAuthor(String id) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete from Author where Id=?");
            query.setParameter(0, id);
            int i = query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            if(i>0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

}
