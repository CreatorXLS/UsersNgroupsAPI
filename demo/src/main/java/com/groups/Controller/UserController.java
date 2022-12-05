package com.groups.Controller;

import com.groups.API.UserService;
import com.groups.Dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        userDTO = userService.createUser(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") Long userId){
        UserDTO userDTO = userService.findUserById(userId);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserDTO> updateEmployee(@PathVariable("id") Long id, @RequestBody UserDTO userDTO){
        userDTO = userService.changeUserName(userDTO, id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

}
