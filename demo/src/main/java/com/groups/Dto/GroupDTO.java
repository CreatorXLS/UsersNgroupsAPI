package com.groups.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupDTO {

    private Long groupId;
    private String groupName;

    private Long userId;
    private List<UserDTO> users;

}
