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
                userDto.getId(),
                userDto.isBlocked(),
                userDto.getToken());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.isBlocked(),
                user.getToken());
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(t -> new UserDto(t.getId(), t.isBlocked(), t.getToken()))
                .collect(Collectors.toList());
    }

}
