package com.groups.API;

import com.groups.ConvertDTO.UserConverter;
import com.groups.DataAccess.UserRepository;
import com.groups.Dto.GroupDTO;
import com.groups.Dto.UserDTO;
import com.groups.Model.UserEntity;
import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity ue = userConverter.convertDTOtoEntity(userDTO);
        ue = userRepository.save(ue);
        userDTO = userConverter.convertEntityToDTO(ue);
        return userDTO;
    }

    @Override
    public UserDTO findUserById(Long userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        UserDTO userDTO = userConverter.convertEntityToDTO(userEntity.get());
        return userDTO;
    }

    @Override
    public UserDTO changeUserName(UserDTO userDTO, Long userId) {
        Optional<UserEntity> optUser = userRepository.findById(userId);
        UserDTO dto = null;
        if(optUser.isPresent()){
            UserEntity user = optUser.get();
            user.setUserName(userDTO.getUserName());
            dto = userConverter.convertEntityToDTO(user);
            userRepository.save(user);
        }

        
        return dto;
    }
}
