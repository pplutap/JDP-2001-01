package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String username;
    private boolean isBlocked;
    private String token;

    public UserDto(long id, boolean isBlocked, String token) {
        this.id = id;
        this.isBlocked = isBlocked;
        this.token = token;
    }
}
