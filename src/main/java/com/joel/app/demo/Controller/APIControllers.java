package com.joel.app.demo.Controller;

import com.joel.app.demo.Models.User;
import com.joel.app.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Bellow tells this call is a controller
@RestController

public class APIControllers {

    @Autowired
    private UserRepo userRepo;



    @GetMapping(value = "/")
    public String getPage(){
        return "WElcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Saved ...";
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User updatingUser){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(updatingUser.getFirstName());
        updatedUser.setLastName(updatingUser.getLastName());
        updatedUser.setAge(updatingUser.getAge());
        userRepo.save(updatedUser);
        return "Updated ...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        userRepo.deleteById(id);
        return "Deleted ...";
    }
}
