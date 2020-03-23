package com.chaiyc.springboot.controller;

import com.chaiyc.springboot.dao.DepartmentDao;
import com.chaiyc.springboot.dao.EmployeeDao;
import com.chaiyc.springboot.entities.Department;
import com.chaiyc.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emp/list")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "emp/list";
    }

    @GetMapping("/emp/add")
    public String toAdd(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping("/emp/addEmp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emp/list";
    }

    @GetMapping("/emp/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        return "emp/add";
    }

    @PutMapping("/emp/addEmp")
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emp/list";
    }

    //员工删除
    @DeleteMapping("/emp/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emp/list";
    }
}
