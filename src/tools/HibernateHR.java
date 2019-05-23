/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.EmployeeDAO;
import models.Employee;
import org.hibernate.SessionFactory;

/**
 *
 * @author Sekar Ayu Safitri
 */
public class HibernateHR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SessionFactory factory = HibernateUtil.getSessionFactory();
        //System.out.println(HibernateUtil.getSessionFactory());
        EmployeeDAO edao = new EmployeeDAO(factory);
//        for (Employee employee : edao.search("le")) {
//            System.out.println(employee.getFirstName());
//        }
        
        System.out.println(edao.getById("110").getFirstName());
    }
    
}
