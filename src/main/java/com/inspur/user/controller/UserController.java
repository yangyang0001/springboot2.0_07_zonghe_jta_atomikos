package com.inspur.user.controller;

import com.inspur.entity.User;
import com.inspur.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: YANG
 * Date: 2019/6/13-3:09
 * Description: No Description
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/insertUser")
    public String insertUser(String username, Integer age){
        int insertCount = userService.insertUser(username, age);
        log.info("InsertUserCount -------------:" + insertCount);
        return Integer.valueOf(insertCount).toString();
    }

    @RequestMapping("/getUserByUserName")
    public User getUserByUserName(String username){
        User user = userService.getUserByUserName(username);
        log.info("getUserByUserName -----------:" + user.toString());
        return user;
    }

    @RequestMapping("/insertUserAndOrder")
    public String insertUserAndOrder(){
        int insertCount = userService.insertUserAndOrder();
        return "" + insertCount;
    }
}
