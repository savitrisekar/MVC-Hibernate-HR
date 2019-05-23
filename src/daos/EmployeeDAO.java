/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IEmployeeDAO;
import java.util.ArrayList;
import java.util.List;
import models.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ACER
 */
public class EmployeeDAO implements IEmployeeDAO {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public EmployeeDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employee = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String query = "FROM Employee";
            employee = session.createQuery(query).list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            factory.close();
        }

        return employee;
    }

    @Override
    public Employee getById(String id) {
        Employee employee = null;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Employee WHERE Id = :emp_id";
            Query query = session.createQuery(hql);
            query.setParameter("emp_id", Integer.parseInt(id));
            employee = (Employee) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            factory.close();
        }

        return employee;
    }

    @Override
    public List<Employee> search(Object key) {
        List<Employee> listEmployee = new ArrayList<Employee>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Employee e WHERE e.firstName LIKE :a OR e.lastName LIKE :b";
            Query query = session.createQuery(hql);
            query.setParameter("a", "%" + key + "%");
            query.setParameter("b", "%" + key + "%");
            listEmployee = query.list();
        } catch (Exception e) {
            e.getStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            factory.close();
        }

        return listEmployee;
    }

    @Override
    public boolean insert(Employee employee) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.save(employee);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.getStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            factory.close();
        }

        return result;
    }

    @Override
    public boolean update(Employee e) {
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        boolean result = false;
        try {
            String hql = "UPDATE Employee SET firstName = :first, lastName = :last"
                    + "WHERE Id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("first", e.getFirstName());
            query.setParameter("last", e.getLastName());
            query.setParameter("id", e.getId());
            query.executeUpdate();
            result = true;
        } catch (Exception d) {
            d.getStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            factory.close();
        }
        
        return result;
    }

    @Override
    public boolean delete(String id) {
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        boolean result = false;
        try {
            String hql = "DELETE FROM Employee WHERE Id = :emp_id";
            Query query = session.createQuery(hql);
            query.setParameter("emp_id", id);
            query.executeUpdate();
            result = true;
        } catch (Exception d) {
            d.getStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            factory.close();
        }

        return result;
    }

}
