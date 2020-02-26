package com.kodilla.ecommercee.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GroupDto {
    private long id;
    private String name;

    public GroupDto(String name) {
        this.name = name;
    }
}
