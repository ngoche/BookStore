package controller;

import dao.CustomerDao;
import dao.EmployeeDao;
import dao.OrderDao;
import entities.Employee;
import entities.OrderInfo;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DuongNguyen
 */
@Controller
public class AdminOrderController {

    private EmployeeDao employeeDao;
    private CustomerDao customerDao;
    private OrderDao orderDao;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @RequestMapping(value = "/listOder")
    public String loadAllOrder(Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            model.addAttribute("listOrder", orderDao.getAllOrder());
            return "orderManagement";
        }
        return "redirect:/requestLogin.htm";

    }

    @RequestMapping(value = "/confirmOrder")
    public String confirmOrderByEmp(@RequestParam("id") String id, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            OrderInfo orderInfo = orderDao.getOrderById(id);
            Employee emp = (Employee) session.getAttribute("emp");
            orderInfo.setEmployeeId(emp);

            boolean blConfirm = orderDao.confirmOrder(orderInfo);
            if (blConfirm) {
                model.addAttribute("Status", "Confirm successfully" + orderInfo.getId());
            } else {
                model.addAttribute("Status", "Confirm faild" + orderInfo.getId());
            }
            model.addAttribute("listOrder", orderDao.getAllOrder());
            return "orderManagement";
        }
        return "redirect:/requestLogin.htm";

    }

    @RequestMapping(value = "/deleteOrder")
    public String deleteOrder(@RequestParam("id") String id, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            boolean blDeleleOrder = orderDao.deleteOrder(id);
            if (blDeleleOrder) {
                model.addAttribute("Status", "Confirm successfully" + id);
            } else {
                model.addAttribute("Status", "Confirm faild" + id);
            }
            session.setAttribute("listOrder", orderDao.getAllOrder());
            return "orderManagement";
        }
        return "redirect:/requestLogin.htm";

    }
}
