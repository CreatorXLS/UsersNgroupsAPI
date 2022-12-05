package com.groups.ConvertDTO;

import com.groups.Dto.UserDTO;
import com.groups.Model.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserConverter {

    public UserEntity convertDTOtoEntity(UserDTO userDTO){
        UserEntity ue = new UserEntity();
//        ue.setUserId(userDTO.getUserId());
        ue.setUserName(userDTO.getUserName());
        return ue;
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
