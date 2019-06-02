package com.moksha.ecommerceweb.Controllers;


import com.moksha.ecommerceweb.Models.User;
import com.moksha.ecommerceweb.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userrepo;

    @GetMapping("/{id}")
    public Optional<User> get(@PathVariable int id){
        return userrepo.findById(id);
    }

    @GetMapping
    public List<User> getAll(){
        return userrepo.findAll();
    }

    @PostMapping
    public User saveUserDetails(@RequestBody User user){
        return userrepo.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userrepo.deleteById(id);
    }

    @GetMapping("{email}")
    @ResponseBody
    public User getOnebyEmail(@PathVariable String email,String password){
        System.out.println("Search User ID");
        return userrepo.findByEmail(email).get();
    }

}

