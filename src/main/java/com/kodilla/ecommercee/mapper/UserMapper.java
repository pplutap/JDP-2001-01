package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getName(),
                userDto.getSurname(),
                userDto.getMail(),
                userDto.getPassword()
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getName(),
                user.getSurname(),
                user.getMail(),
                user.getPassword()
        );
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(t -> new UserDto(t.getName(), t.getSurname(), t.getMail(), t.getPassword()))
                .collect(Collectors.toList());
    }

}
