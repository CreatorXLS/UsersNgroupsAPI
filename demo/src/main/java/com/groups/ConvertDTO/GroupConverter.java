package com.groups.ConvertDTO;

import com.groups.Dto.GroupDTO;
import com.groups.Dto.UserDTO;
import com.groups.Model.GroupEntity;
import com.groups.Model.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GroupConverter {

    public GroupEntity convertDTOtoEntity(GroupDTO groupDTO){
        GroupEntity ge = new GroupEntity();
//        ge.setGroupId(groupDTO.getGroupId());
        ge.setGroupName(groupDTO.getGroupName());

        return ge;
    }

    public GroupDTO convertEntitytoDTO(Optional<GroupEntity> groupEntity){
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setGroupId(groupEntity.get().getGroupId());
        groupDTO.setGroupName(groupEntity.get().getGroupName());
        groupDTO.setUserId(groupDTO.getUserId());
        List<UserEntity> userEntityList = groupEntity.get().getUsers();

       List<UserDTO> userDTOList = convertEntityListtoDTO(userEntityList);
       groupDTO.setUsers(userDTOList);

        return groupDTO;
    }


    public UserDTO convertEntityToDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setUserName(userEntity.getUserName());
        return userDTO;
    }

    public List<UserDTO> convertEntityListtoDTO(List<UserEntity> userEntities){
        List<UserDTO> userDTOList = new ArrayList<>();
        for(UserEntity userEntity:  userEntities){
            UserDTO userDTO = convertEntityToDTO(userEntity);
            userDTOList.add(userDTO);
            System.out.println(userEntity);
        }
        return userDTOList;

    }

}
