package com.example.department.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository dept_repo;

    public String add_dept(Department dept)
    {
        try
        {
            dept_repo.save(dept);
            return "successfully added Department";
        }
        catch(Exception e)
        {
            return "failed at adding department";
        }
    }

    public List<Department> get_Departments()
    {
        return (List<Department>) dept_repo.findAll();
    }

    public Department get_dept_by_id(int id)
    {
        try
        {
            return dept_repo.findById(id).get();
        }
        catch(Exception e)
        {
            return null;
        }
    }

}
