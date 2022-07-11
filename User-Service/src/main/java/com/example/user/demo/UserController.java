package com.example.user.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.security.cert.Extension;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService user_serv;

    @GetMapping("")
    public String users()
    {
        return "Users Repo";
    }

    @GetMapping("/all")
    public List<UserDetails> get_all_users()
    {
        return user_serv.get_all_users();
    }

    @GetMapping("/{id}")
    public UserResponseTemplate get_user_by_id(@PathVariable int id)
    {
        return user_serv.get_users_by_id(id);
    }

    @PostMapping("")
    public String add_user(@RequestBody UserDetails user)
    {
        return user_serv.add_user(user);
    }
}
