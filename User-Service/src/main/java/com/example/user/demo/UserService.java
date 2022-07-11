package com.example.user.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository user_repo;

    @Autowired
    private RestTemplate restTemplate;

    public List<UserDetails> get_all_users()
    {
        try
        {
            return user_repo.findAll();
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    public UserResponseTemplate get_users_by_id(@PathVariable int id)
    {
        try
        {
            UserDetails u=user_repo.findById(id).get();
            System.out.println(u);

            Department d= restTemplate.getForObject("http://localhost:8000/departments/1", Department.class);

            System.out.println("Dept = "+d);

            UserResponseTemplate res=new UserResponseTemplate();
            res.setUser(u);
            res.setDepartment(d);
            return res;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    public String add_user(@RequestBody UserDetails user)
    {
        try
        {
            user_repo.save(user);
            return "successfully added User";
        }
        catch(Exception e)
        {
            return "fail while adding user";
        }
    }

}
