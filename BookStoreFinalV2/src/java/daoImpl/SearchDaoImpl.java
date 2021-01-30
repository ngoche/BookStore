/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.SearchDao;
import entities.Account;
import entities.Book;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Acer
 */
public class SearchDaoImpl implements SearchDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Book> searchBook(String name) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            if (name == null) {
                name = "%";
            } else {
                name = "%" + name + "%";
            }
            Query query = session.createQuery("from Book where BookName like :name");
            query.setParameter("name", name);
            List<Book> b = query.list();
            session.getTransaction().commit();
            session.close();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;

    }

    @Override
    public List<Book> searchBookByName(String name) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Criteria cr = session.createCriteria(Book.class);
            cr.add(Restrictions.ilike("bookName", "%" + name + "%"));
            List list = cr.list();
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
    public List<Book> searchBookByCategory(String name) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            if (name == null) {
                name = "%";
            } else {
                name = "%" + name + "%";
            }
            Query query = session.createQuery("from Book where bookCategoryId.name like :name");
            query.setParameter("name", name);
            List<Book> b = query.list();
            session.getTransaction().commit();
            session.close();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<Book> searchBookByAuthor(String name) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            if (name == null) {
                name = "%";
            } else {
                name = "%" + name + "%";
            }
            Query query = session.createQuery("from Book where authorId.name like :name");
            query.setParameter("name", name);
            List<Book> b = query.list();
            session.getTransaction().commit();
            session.close();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<Book> searchBookByPublisher(String name) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            if (name == null) {
                name = "%";
            } else {
                name = "%" + name + "%";
            }
            Query query = session.createQuery("from Book where publisherId.name like :name");
            query.setParameter("name", name);
            List<Book> b = query.list();
            session.getTransaction().commit();
            session.close();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    //chia list de phan trang   
    @Override
    public List<Book> resultSearchBook(List<Book> list, Integer offset, Integer maxResults) {
        if(list==null || list.isEmpty())
            return null;
        else{
            int off = offset==null?0:offset;
            int max = maxResults==null?10:maxResults;
            return list.subList(off, (off+max)<list.size()?(off+max):list.size());
        }
    }

    @Override
    public List<Account> resultSearchCustomer(List<Account> list, Integer offset, Integer maxResults) {
        if(list==null || list.isEmpty())
            return null;
        else{
            int off = offset==null?0:offset;
            int max = maxResults==null?10:maxResults;
            return list.subList(off, (off+max)<list.size()?(off+max):list.size());
        }
    }

    @Override
    public List<Account> searchCusByUser(String name) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            if (name == null) {
                name = "%";
            } else {
                name = "%" + name + "%";
            }
            Query query = session.createQuery("from Account where userName like :name");
            query.setParameter("name", name);
            List<Account> b = query.list();
            session.getTransaction().commit();
            session.close();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<Account> searchCusByName(String name) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            if (name == null) {
                name = "%";
            } else {
                name = "%" + name + "%";
            }
            Query query = session.createQuery("from Account where customerId.fullName like :name");
            query.setParameter("name", name);
            List<Account> b = query.list();
            session.getTransaction().commit();
            session.close();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<Account> searchCusByType(String name) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            if (name == null) {
                name = "%";
            } else {
                name = "%" + name + "%";
            }
            Query query = session.createQuery("from Book where customerId.customerTypeId.type like :name");
            query.setParameter("name", name);
            List<Account> b = query.list();
            session.getTransaction().commit();
            session.close();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<Account> searchCusByAddress(String name) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            if (name == null) {
                name = "%";
            } else {
                name = "%" + name + "%";
            }
            Query query = session.createQuery("from Account where customerId.address like :name");
            query.setParameter("name", name);
            List<Account> b = query.list();
            session.getTransaction().commit();
            session.close();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }
}
