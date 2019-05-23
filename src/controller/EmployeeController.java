/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.EmployeeDAO;
import icontroller.IEmployeeController;
import idaos.IEmployeeDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ACER
 */
public class EmployeeController implements IEmployeeController {

    private IEmployeeDAO edao;

    public EmployeeController(SessionFactory factory) {
        edao = new EmployeeDAO(factory);
    }

    @Override
    public List<Employee> getAll() {
        return edao.getAll();
    }

    @Override
    public Employee getById(String id) {
        return edao.getById(id);
    }

    @Override
    public List<Employee> search(Object key) {
        return edao.search(key);
    }

    @Override
    public String insert(String salary, String firstName, String lastName, String email) {
        Employee employee = new Employee(firstName, lastName, email, new BigDecimal(salary));
        if (edao.insert(employee)) {
            return "Insert success";
        } else {
            return "Insert failed";
        }
    }

    @Override
    public String update(String id, String firstName, String lastName, String salary) {
        Employee employee = new Employee(firstName, lastName, id, new BigDecimal(salary));
        if (edao.insert(employee)) {
            return "Update success";
        } else {
            return "Update failed";
        }
    }

    @Override
    public String delete(String id) {
        if (edao.delete(id)) {
            return "Delete success";
        } else {
            return "Delete failed";
        }
    }

}
