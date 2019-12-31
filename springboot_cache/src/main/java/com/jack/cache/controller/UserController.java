package com.jack.cache.controller;

import com.jack.cache.bean.User;
import com.jack.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PC20
 * @create 2019/8/12
 */
@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("user/{id}")
    public String getUser(@PathVariable Integer id) {
        return userService.getUser(id).toString();
    }


    @GetMapping("user")
    public User update(User user) {
        return userService.updateUser(user);
    }

    @GetMapping("deluser/{id}")
    public void delUser(@PathVariable Integer id) {
        userService.delUser(id);
    }

}
