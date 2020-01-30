package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/project")

public class GroupController {
    @RequestMapping(method= RequestMethod.GET, value="getGroups")
    public List<String> getGroups() {
        return new ArrayList<>();
    }
    @RequestMapping(method=RequestMethod.POST, value="addGroup")
    public void addGroup(String groupDto) {

    }
    @RequestMapping(method=RequestMethod.GET, value="getGroup")
    public String getGroup(Long groupId) {
        return "GroupDto with Id: groupId";
    }
    @RequestMapping(method=RequestMethod.PUT, value="updateGroup")
    public String updateGroup(String groupDto) {
        return "Updated groupDto";
    }
}
