/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import entities.Account;
import entities.Customer;
import bookstore.model.CustomerInfo;
import dao.LoginDao;
import entities.CustomerType;
import entities.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Acer
 */
public class LoginDaoImpl implements LoginDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Account getAccountByUserAndPass(String username, String password) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Account where Username=? and Password=?");
            query.setParameter(0, username);
            query.setParameter(1, password);
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
    public Boolean checkAccountExistsed(String userName) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Account where userName=?");
            query.setParameter(0, userName);
            Account acc = (Account) query.uniqueResult();//Phương thức thuận tiện để trả về một cá thể đơn lẻ khớp với truy vấn, 
            //hoặc null nếu truy vấn không trả về kết quả nào.
            session.getTransaction().commit();
            session.close();
            if (acc != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public Boolean createAccount(CustomerInfo acc) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            Query query = session.createQuery("from CustomerType where Id=?");
            query.setParameter(0, acc.getCustomerTypeId());
            CustomerType c = (CustomerType) query.uniqueResult();

            Customer cu = new Customer();
            cu.setAddress(acc.getAddress());
            cu.setBirthday(acc.getBirthday());
            cu.setEmail(acc.getEmail());
            cu.setFullName(acc.getFullName());
            cu.setGender(acc.isGender());
            cu.setPhone(acc.getPhone());
            cu.setCustomerTypeId(c);
            session.save(cu);

            query = session.createQuery("from Customer where Email=?");
            query.setParameter(0, acc.getEmail());
            Customer cus = (Customer) query.uniqueResult();

            Account ac = new Account();
            ac.setUsername(acc.getUsername());
            ac.setPassword(acc.getPassword());
            ac.setCustomerId(cus);
            session.save(ac);

            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public Account getAccountByUser (String username) {
        try {
            Session ss = sessionFactory.openSession();
            ss.beginTransaction();
            Query qr = ss.createQuery("from Account  where Username=?");
            qr.setParameter(0, username);
            Account ac = (Account) qr.uniqueResult();
            ss.getTransaction().commit();
            ss.close();
            return ac;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean checkAdmin(String username, String pass) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Employee where Username=? and Password=?");
            query.setParameter(0, username);
            query.setParameter(1, pass);
            Employee emp = (Employee) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            if (emp != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }
}
