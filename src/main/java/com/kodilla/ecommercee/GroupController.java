package com.kodilla.ecommercee;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    public List<String> getGroups() {
        return new ArrayList<>();
    }

    public void addGroup(String groupDto) {

    }

    public String getGroup(Long groupId) {
        return "GroupDto with Id: groupId";
    }

    public String updateGroup(String groupDto) {
        return "Updated groupDto";
    }
}
