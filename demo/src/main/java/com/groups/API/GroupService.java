package com.groups.API;

import com.groups.Dto.GroupDTO;
import com.groups.Dto.UserDTO;
import com.groups.Model.GroupEntity;
import com.groups.Model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    GroupDTO createGroup(GroupDTO groupDTO); // WORKING

    List<GroupDTO> getAllGroups(); // WORKING

    GroupDTO addUserToGroup(GroupDTO groupDTO); // WORKING

    void removeUserFromGroup(Long userId, UserDTO userDTO);

    Optional<GroupDTO> findGroupById(Long id); // WORKING

    List<UserEntity> findGroupUsers(Long id);


}
