/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import entities.Account;
import entities.Customer;
import dao.AccountDao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Acer
 */
public class AccountDaoImp implements AccountDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Account getAccountIdByUser(String username) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Account where Username=?");
            query.setParameter(0, username);
            Account acc = (Account) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return acc;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Customer getData(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Customer where Id=?");
            query.setParameter(0, id);
            Customer acc = (Customer) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return acc;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        Customer acc = new Customer();
        return acc;
    }

    @Override
    public boolean ModifyAccount(Account a, Customer c) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(a);
            session.update(c);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean DeleteAccount(String username) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("delete from Account where username=?");
            query.setParameter(0, username);
            int i = query.executeUpdate();
//            query = session.createQuery("delete from Customer where id=?");
//            query.setParameter(0, id);
//            int j = query.executeUpdate();
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
    public Boolean DeleteCostomer(Integer id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("delete from Customer where id=?");
            query.setParameter(0, id);
            int j = query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            if (j > 0) {
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
    public Account getAccountByUser(String username) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Account where Username=?");
            query.setParameter(0, username);
            Account acc = (Account) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return acc;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        Account acc = new Account();
        acc.setUsername("tao");
        acc.setPassword("dan choi");
        return acc;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Customer where id=?");
            query.setParameter(0, id);
            Customer acc = (Customer) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return acc;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }
    @Override
    public List<Account> getAllAccount() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Account");
            List<Account> list = query.list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }
}
