package com.bluetreetask.repository;

import com.bluetreetask.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class EmployeeRepoImpl implements EmployeeRepo{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        Session s=sessionFactory.openSession();
        Query q = s.createQuery("from Employee");
        List<Employee> employeeList=q.list();
        s.close();
        return employeeList;
    }
    @Override
    public Employee getEmployeeById(int empId){
        for(Employee employee:this.getAllEmployees()){
            if (employee.getEmpId()==empId) {

                return employee;
            }
        }
        return null;
    }
    @Override
    public Employee addEmployee(Employee emp) {
        Session s = sessionFactory.openSession();
        Transaction tr = s.beginTransaction();
        s.save(emp);
        tr.commit();
        s.close();
        return emp;
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        Session s = sessionFactory.openSession();
        Transaction tr = s.beginTransaction();
        List<Employee> employeeList=this.getAllEmployees();
        for(Employee employee:employeeList){
            if(employee.getEmpId()==emp.getEmpId()){
                employee.setEmpName(emp.getEmpName());
                employee.setEmail(emp.getEmail());
                employee.setDob(emp.getDob());
                employee.setAge(emp.getAge());
                employee.setSalary(emp.getSalary());
                employee.setStatus(emp.getStatus());
                s.saveOrUpdate(employee);
                break;
            }
        }
        tr.commit();
        s.close();
        return emp;
    }

    @Override
    public boolean deleteEmployee(int empId) {
        Session s = sessionFactory.openSession();
        Transaction tr = s.beginTransaction();
        for(Employee employee:this.getAllEmployees()){
            if (employee.getEmpId()==empId) {
                s.delete(employee);
                break;
            }
        }
        tr.commit();
        s.close();
        return false;
    }
}
