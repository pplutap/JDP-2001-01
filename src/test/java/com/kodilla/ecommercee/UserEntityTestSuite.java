package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityTestSuite {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    User user1 = new User("Maja");
    User user2 = new User("Kasia");

    @Test
    public void testUserRepositorySave() {
        //When
        userRepository.save(user1);
        //Then
        long id = user1.getId();
        Optional<User> users = userRepository.findById(id);
        Assert.assertTrue(users.isPresent());
    }

    @Test
    public void testUserRepositoryFindAll() {
        //When
        userRepository.save(user1);
        userRepository.save(user2);
        //Then
        Assert.assertEquals(userRepository.findAll().size(), 2);
    }

}
