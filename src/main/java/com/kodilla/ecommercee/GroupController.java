package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("v1/project/groups")

public class GroupController {
    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
        return Arrays.asList(new GroupDto(1L,"Group1"),new GroupDto(2L,"Group2"));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addGroup")
    public void addGroup(GroupDto groupDto) {

    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroup")
    public GroupDto getGroup(Long groupId) {
        return new GroupDto(1L,"Group1");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public GroupDto updateGroup(GroupDto groupDto) {
        return new GroupDto(1L,"Updated Group1");
    }
}
