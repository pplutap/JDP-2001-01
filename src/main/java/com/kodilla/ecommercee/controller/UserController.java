package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.TokenGenerator;
import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/project/users")
public class UserController {

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createUser(UserDto userDto) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public void blockUser(UserDto userDto) {

    }

    @RequestMapping(method = RequestMethod.GET, value = "getToken")
    public String getToken(Long userId) {
        TokenGenerator tokenGenerator = new TokenGenerator();
        return tokenGenerator.generateToken();

    }

}
