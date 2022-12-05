package com.groups.API;

import com.groups.Dto.UserDTO;


public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO findUserById(Long userId);

    UserDTO changeUserName(UserDTO userDTO, Long userId);
}
