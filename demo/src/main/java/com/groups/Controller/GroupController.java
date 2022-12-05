package com.groups.Controller;

import com.groups.API.GroupService;
import com.groups.Dto.GroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1")
@RestController
public class GroupController  {

    @Autowired
    private GroupService groupService;


    @PostMapping("/group")
    public ResponseEntity<GroupDTO> saveGroup(@RequestBody GroupDTO groupDTO){
        groupDTO = groupService.createGroup(groupDTO);
        ResponseEntity<GroupDTO> responseEntity = new ResponseEntity<>(groupDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/addUsersToGroup")
    public ResponseEntity<GroupDTO> addUsersToGroup(@RequestBody GroupDTO groupDTO){
        groupDTO = groupService.addUserToGroup(groupDTO);

        ResponseEntity<GroupDTO> responseEntity = new ResponseEntity<>(groupDTO, HttpStatus.CREATED);

        return responseEntity;
    }


    @GetMapping("/group")
    public ResponseEntity<List<GroupDTO>> getAllGroups(){
        List<GroupDTO> groupDTOList = groupService.getAllGroups();
        return new ResponseEntity<>(groupDTOList, HttpStatus.OK);
    }

    @GetMapping("/group/{groupId}")
    public Optional<GroupDTO> getGroupById(@PathVariable("groupId") Long groupId){
        Optional<GroupDTO> groupDTO = groupService.findGroupById(groupId);
        return groupDTO;
    }

    @DeleteMapping("/group/{userId}")
    public void deleteUserInGroup(@PathVariable("userId") Long userId){
//         groupService.removeUserFromGroup();
    }


}
