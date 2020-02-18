package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserNotFoundException;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDbService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(final Long id) throws UserNotFoundException {
        return userRepository.findById(id);
    }

    public void deleteUser(final long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public User createUser(final User user) {
        return userRepository.save(user);
    }

    public void blockUser(final User user) {
        if (userRepository.existsById(user.getId())) {
            User userToBlock = userRepository.getOne(user.getId());
            if (!userToBlock.isBlocked()) {
                userToBlock.setBlocked(true);
            }
            userRepository.save(userToBlock);
        }
    }
}
