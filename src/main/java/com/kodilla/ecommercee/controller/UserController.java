package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.TokenGenerator;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.domain.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/project/users")
public class UserController {
    @Autowired
    private UserDbService service;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(service.getAllUsers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public UserDto getUser(@RequestParam long id)  {
        return userMapper.mapToUserDto(service.getUser(id).orElseThrow(UserNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST,value = "saveUser")
    public void saveUser(@RequestBody UserDto userDto) {
        service.saveUser(userMapper.mapToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createUser(@RequestBody UserDto userDto) {
        service.createUser(userMapper.mapToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public void blockUser(@RequestBody UserDto userDto) {
        service.blockUser(userMapper.mapToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "deleteUser")
    public void deleteUser(@RequestParam long id) {
        service.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getToken")
    public String getToken() {
        TokenGenerator tokenGenerator = new TokenGenerator();
        return tokenGenerator.generateToken();

    }

}
