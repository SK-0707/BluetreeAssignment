package com.bluetreetask.controller;


import com.bluetreetask.model.Employee;
import com.bluetreetask.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepo;
    @RequestMapping("/")
    public String displayHomepage(Model m){
        List<Employee> empData =employeeRepo.getAllEmployees();
        m.addAttribute("empData", empData);
        return "index";
    }

    @RequestMapping("/addemployee")
    public String addEmployeepage(){
        return "addemployee";
    }

    @PostMapping("submitdetails")
    public String addEmployee(@RequestParam("empName") String empName,
                              @RequestParam("email") String email,
                              @RequestParam("dob") String dob,
                              @RequestParam("salary") String salary,
                              @RequestParam("status") String status){
        Date today = Date.valueOf(LocalDate.now());
        Date bdate=Date.valueOf(dob);
        int age=today.getYear()-bdate.getYear();

        Employee emp=new  Employee(0,empName,email,bdate,age,Double.parseDouble(salary),Boolean.valueOf(status));
        System.out.println(emp);
        employeeRepo.addEmployee(emp);

        return "redirect:/";
    }

    @RequestMapping("/deletermp")
    public String deleteEmployee(@RequestParam("empId") String empId){

        System.out.println("Deleting Employee With Id"+empId);
        employeeRepo.deleteEmployee(Integer.parseInt(empId));

        return "redirect:/";
    }
    @RequestMapping("/updateinfo")
    public String updateeEmployee(@RequestParam("empId") String empId,Model m){
        Employee employee=employeeRepo.getEmployeeById(Integer.parseInt(empId));
        m.addAttribute("e",employee);
        return "updateemployee";
    }
    @PostMapping("updatedetails")
    public String updateEmployee(@RequestParam("empId") String empId,
                              @RequestParam("empName") String empName,
                              @RequestParam("email") String email,
                              @RequestParam("dob") String dob,
                              @RequestParam("salary") String salary,
                              @RequestParam("status") String status){
        Date today = Date.valueOf(LocalDate.now());
        Date bdate=Date.valueOf(dob);
        int age=today.getYear()-bdate.getYear();

        Employee emp=new  Employee(Integer.parseInt(empId),empName,email,bdate,age,Double.parseDouble(salary),Boolean.valueOf(status));
        System.out.println(emp);
        employeeRepo.updateEmployee(emp);

        return "redirect:/";
    }
}
