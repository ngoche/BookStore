/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Employee;
import java.util.List;

/**
 *
 * @author DuongNguyen
 */
public interface EmployeeDao {
    public List<Employee> getAllEmp();
    public Employee getEmpById(String Id);
    public Employee getEmpByUserName(String User);
    public Boolean updateInfoEmp(Employee emp);
    public Boolean deleteEmp(String id);
}
