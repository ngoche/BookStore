package controller;

import bookstore.model.CustomerInfo;
import dao.AccountDao;
import dao.CustomerDao;
import dao.CustomerTypeDao;
import dao.SearchDao;
import entities.Account;
import entities.Customer;
import entities.CustomerType;
import java.io.Serializable;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DuongNguyen
 */
@Controller
public class AdminAccCustomerController implements Serializable {

    private CustomerDao customerDAO;
    private CustomerTypeDao customerTypeDAO;
    private AccountDao accountDAO;
    private SearchDao searchDao;

    @Autowired
    public void setSearchDao(SearchDao searchDao) {
        this.searchDao = searchDao;
    }
    

    @Autowired
    public void setAccountDAO(AccountDao accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Autowired
    public void setCustomerTypeDAO(CustomerTypeDao customerTypeDAO) {
        this.customerTypeDAO = customerTypeDAO;
    }

    @Autowired
    public void setCustomerDAO(CustomerDao customerDAO) {
        this.customerDAO = customerDAO;
    }
    
    @RequestMapping(value = "/searchCusAdmin")
    public String SearchCusAdmin(@ModelAttribute("cusInfo") CustomerInfo cusInfo, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            List<Account> listSearch = null;
            if (cusInfo.getCustomerTypeId()== 0) {
                listSearch = searchDao.searchCusByName(cusInfo.getFullName());
            } else if (cusInfo.getCustomerTypeId() == 1) {
                listSearch = searchDao.searchCusByUser(cusInfo.getFullName());
            } else if (cusInfo.getCustomerTypeId() == 2) {
                listSearch = searchDao.searchCusByAddress(cusInfo.getFullName());
            } else if (cusInfo.getCustomerTypeId() == 3) {
                listSearch = searchDao.searchCusByType(cusInfo.getFullName());
            } else {
                listSearch = null;
            }

            if (listSearch == null) {
                model.addAttribute("cusInfo", new CustomerInfo());
                model.addAttribute("error", "Không có dữ liệu nào trong csdl");
                return "redirect:/listAccCus.htm";
            } else {
                session.setAttribute("ResultsListAcc", listSearch);
                return "redirect:/resultSearchCus.htm";
            }
        } else {
            return "redirect:/requestLogin.htm";
        }
    }
    @RequestMapping(value = "/resultSearchCus")
    public String resultSearchCus(Model model, Integer offset, Integer maxResults, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            List<Account> list = (List<Account>) session.getAttribute("ResultsListAcc");
            model.addAttribute("listResultAcc",searchDao.resultSearchCustomer(list, offset, maxResults));
            model.addAttribute("offset", offset);
            model.addAttribute("count", list.size());
            model.addAttribute("cusInfo", new CustomerInfo());
            return "resultSearchCus";
        }
            return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/listAccCus")
    public String loadAccCustomer(Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            session.setAttribute("listAccount", accountDAO.getAllAccount());
            model.addAttribute("cusInfo", new CustomerInfo());
            return "customerManagement";
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/detailAccCus")
    public String loadDetailAccCustomer(@RequestParam("user") String user, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            Account acc = accountDAO.getAccountByUser(user);
            Customer cus = acc.getCustomerId();
            model.addAttribute("detailAcc", acc);
            model.addAttribute("detailCus", cus);
            return "customerDetail";
        }
        return "redirect:/requestLogin.htm";

    }

    @RequestMapping(value = "/deleteAccCus")
    public String deleteCustomer(@RequestParam("user") String user, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            Account acc = accountDAO.getAccountByUser(user);
            Customer cus = acc.getCustomerId();
            boolean blDeleteAcc = accountDAO.DeleteAccount(user);
            if (blDeleteAcc) {
                boolean blDeleteCus = customerDAO.deleteCustomer(Integer.toString(cus.getId()));
                if (blDeleteCus) {
                    model.addAttribute("Status", "Remove successfully  has id:" + cus.getId());
                    session.setAttribute("listAccount", accountDAO.getAllAccount());
                    return "customerManagement";
                } else {
                    model.addAttribute("Status", "Remove failed has id:" + cus.getId());
                }
            } else {
                model.addAttribute("Status", "Remove failed has id:" + cus.getId());
            }
            session.setAttribute("listAccount", accountDAO.getAllAccount());
            return "customerManagement";
        }
        return "redirect:/requestLogin.htm";

    }
    //Customer Type     //Customer Type     //Customer Type    //Customer Type
    //Customer Type     //Customer Type     //Customer Type    //Customer Type
    //Customer Type     //Customer Type     //Customer Type    //Customer Type
    //Customer Type     //Customer Type     //Customer Type    //Customer Type
    //Customer Type     //Customer Type     //Customer Type    //Customer Type
    //Customer Type     //Customer Type     //Customer Type    //Customer Type
    //Customer Type     //Customer Type     //Customer Type    //Customer Type

    @RequestMapping(value = "/listCustomerType")
    public String loadAllCustomerType(Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            session.setAttribute("listCusType", customerTypeDAO.getAllCustomerType());
            return "customerTypeManagement";
        }
        return "redirect:/requestLogin.htm";

    }

    @RequestMapping(value = "/preUpdateCusType")
    public String initUpdateCusType(@RequestParam("id") String id, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            CustomerType type = customerTypeDAO.getCustomerTypeById(id);
            model.addAttribute("type", type);
            return "updateCusType";
        }
        return "redirect:/requestLogin.htm";

    }

    @RequestMapping(value = "/updateCusType", method = RequestMethod.POST)
    public String updateCusType(@Valid @ModelAttribute("type") CustomerType type, BindingResult result, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            if (result.hasErrors()) {
                model.addAttribute("type", type);
                model.addAttribute("Status", "Update failed has id:" + type.getId());
                return "updateCusType";
            } else {
                boolean blUpdate = customerTypeDAO.updateCusType(type);
                if (blUpdate) {
                    model.addAttribute("Status", "Update successfully has id:" + type.getId());
                    session.setAttribute("listCusType", customerTypeDAO.getAllCustomerType());
                    return "customerTypeManagement";
                } else {
                    model.addAttribute("Status", "Update failed has id:" + type.getId());
                    session.setAttribute("listCusType", customerTypeDAO.getAllCustomerType());
                    return "updateCusType";
                }
            }
        }
        return "redirect:/requestLogin.htm";
    }

    @RequestMapping(value = "/initInsertCusType")
    public String initInsertCusType(Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            model.addAttribute("type", new CustomerType());
            return "insertCusType";
        }
        return "redirect:/requestLogin.htm";

    }

    @RequestMapping(value = "/insertCusType", method = RequestMethod.POST)
    public String insertCusType(@Valid @ModelAttribute("type") CustomerType type, BindingResult result, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            if (result.hasErrors()) {
                model.addAttribute("type", type);
                model.addAttribute("Status", "Add failed has id:" + type.getId());
                return "insertCusType";
            } else {
                boolean blInsert = customerTypeDAO.insertCusType(type);
                if (blInsert) {
                    model.addAttribute("Status", "Add successfully for CustomerType has id:" + type.getId());
                    session.setAttribute("listCusType", customerTypeDAO.getAllCustomerType());
                    return "customerTypeManagement";
                } else {
                    model.addAttribute("Status", "Add failed");
                    model.addAttribute("type", type);
                    return "insertCusType";
                }
            }
        }
        return "redirect:/requestLogin.htm";

    }

    @RequestMapping(value = "/deleteCusType")
    public String deleteCusType(@RequestParam("id") String id, Model model, HttpSession session) {
        if (session.getAttribute("isLogin") != null) {
            boolean blDelete = customerTypeDAO.deleteCusType(id);
            if (blDelete) {
                model.addAttribute("Status", "Remove successfully for CustomerType has id:" + id);
            } else {
                model.addAttribute("Status", "Remove failed! id= " + id + "!Có thể còn Khách Hàng có thể loại này,Hãy xóa nó đi");
            }
            session.setAttribute("listCusType", customerTypeDAO.getAllCustomerType());
            return "customerTypeManagement";
        }
        return "redirect:/requestLogin.htm";
    }
}
