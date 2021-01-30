/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.EmployeeDao;
import entities.Employee;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author DuongNguyen
 */
public class EmployeeDaoImpl implements EmployeeDao{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    

    @Override
    public List<Employee> getAllEmp() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Employee");
            List<Employee> list = query.list();
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
    public Employee getEmpById(String Id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Employee where Id=?");
            query.setParameter(0, Id);
            Employee emp = (Employee) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return emp;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Boolean updateInfoEmp(Employee emp) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(emp);
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
    public Boolean deleteEmp(String id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete from Employee where Id=?");
            query.setParameter(0, id);
            int i=query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            if(i>0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public Employee getEmpByUserName(String User) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Employee where Username=?");
            query.setParameter(0, User);
            Employee emp = (Employee) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return emp;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }
    
    
}
