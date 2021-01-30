/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import entities.Book;
import bookstore.model.BookCart;
import dao.PayDao;
import dao.PayDao;
import entities.Customer;
import entities.OrderDetail;
import entities.OrderDetailPK;
import entities.OrderInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ngocv
 */
public class PayDaoImpl implements PayDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Boolean saveOrderInfo(Customer customer, BookCart books) {
        Session session = sessionFactory.openSession();

        try {
            Date timeDate = new Date();
            SimpleDateFormat formateDate = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy ");
            final String gettingTime = formateDate.format(timeDate.getTime());
            session.beginTransaction();
            Query query = session.createQuery("from Customer where Email=?");
            query.setParameter(0, customer.getEmail());
            Customer cus = (Customer) query.uniqueResult();

            OrderInfo info = new OrderInfo();
            info.setCustomerId(cus);
            info.setEmployeeId(null);
            info.setOrderDate(gettingTime);
            session.persist(info);

            List<BookCart> lista = books.getList();
            for (BookCart bookCart : lista) {
                for (Book b : lista) {
                    if (bookCart.getIsbn().equals(b.getIsbn())) {
                        OrderDetail orderDetail = new OrderDetail();
                        OrderDetailPK orderDetailPK = new OrderDetailPK();
                        orderDetail.setTransactionDate(gettingTime);
                        orderDetail.setNote(null);
                        orderDetail.setOrderInfo(info);
                        orderDetail.setBook(b);
                        orderDetail.setQuantity(bookCart.getNumberOfBook());
                        orderDetailPK.setBookIsbn(b.getIsbn());
                        orderDetailPK.setOrderId(info.getId());
                        orderDetail.setOrderDetailPK(orderDetailPK);
                        session.persist(orderDetail);
                        break;
                    }
                }
            }

            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
