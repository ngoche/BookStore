/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.PublisherDao;
import entities.Publisher;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ngocv
 */
public class PublisherDaoImpl implements PublisherDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Publisher");
            List list = query.list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getNamePublisherById(String id) {
                Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Publisher where Id=?");
            query.setParameter(0, id);
            Publisher publisher = (Publisher) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return publisher.getName();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }
    @Override
    public Publisher getPublisherById(String id) {
       Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Publisher where Id=?");
            query.setParameter(0, id);
            Publisher pub = (Publisher) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return pub;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Boolean insertPublisher(Publisher pub) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(pub);
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
    public Boolean updatePublisher(Publisher pub) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(pub);
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
    public Boolean deletePublisher(String id) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete from Publisher where Id=?");
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

