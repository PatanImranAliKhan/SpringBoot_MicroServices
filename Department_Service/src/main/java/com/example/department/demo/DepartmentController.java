package com.example.department.demo;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@CrossOrigin("*")
public class DepartmentController {


    @Autowired
    DepartmentService dept_serv;

    @GetMapping("")
    public String departments()
    {
        return "Departments repo";
    }

    @GetMapping("/all")
    public List<Department> get()
    {
        return dept_serv.get_Departments();
    }

    @PostMapping("")
    public String add_data(@RequestBody Department dept)
    {
        return dept_serv.add_dept(dept);
    }

    @GetMapping("{id}")
    public Department get_by_id(@PathVariable int id)
    {
        return dept_serv.get_dept_by_id(id);
    }
}
