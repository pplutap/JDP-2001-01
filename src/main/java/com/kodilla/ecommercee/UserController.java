package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
public class UserController {

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createUser(String userDto) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public void blockUser(String userDto) {

    }

    @RequestMapping(method = RequestMethod.GET, value = "getToken")
    public void getToken(Long userId) {

    }

}
