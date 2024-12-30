package com.squidco.demo.router;


import com.squidco.demo.entity.User;
import com.squidco.demo.service.UserService;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


// user recource rest controller

@RestController
@RequestMapping("/api/users")
public class UserRouter {

    private UserService service;

    public UserRouter(UserService userService) {
        service = userService;
    }

    @GetMapping("")
    public List<User> getAll() {
        return service.findAll();
    }


    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return service.save(user);
    }

    @GetMapping("/{idParam}")
    public User getOneUser(@PathVariable(value="idParam") long id) {
        return service.findById(id);
    }
    

} 
