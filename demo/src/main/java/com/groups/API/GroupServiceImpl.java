package com.groups.API;

import com.groups.ConvertDTO.GroupConverter;
import com.groups.ConvertDTO.UserConverter;
import com.groups.DataAccess.GroupRepository;
import com.groups.DataAccess.UserRepository;
import com.groups.Dto.GroupDTO;
import com.groups.Dto.UserDTO;
import com.groups.Model.GroupEntity;
import com.groups.Model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupConverter groupConverter;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;


    @Override
    public GroupDTO createGroup(GroupDTO groupDTO) {
        GroupEntity ge = groupConverter.convertDTOtoEntity(groupDTO);
        ge = groupRepository.save(ge);
        groupDTO = groupConverter.convertEntitytoDTO(Optional.of(ge));
        return groupDTO;
    }

    @Override
    public List<GroupDTO> getAllGroups() {
        List<GroupEntity> groupList = groupRepository.findAll();
        List<GroupDTO> listOfGroups = new ArrayList<>();
        for(GroupEntity ge : groupList){
            GroupDTO groupDTO = groupConverter.convertEntitytoDTO(Optional.ofNullable(ge));
            listOfGroups.add(groupDTO);
        }
        return listOfGroups;
    }

    @Override
    public GroupDTO addUserToGroup(GroupDTO groupDTO) {
        Optional<UserEntity> optUser = userRepository.findById(groupDTO.getUserId());
        if(optUser.isPresent()){
            GroupEntity ge = groupConverter.convertDTOtoEntity(groupDTO);

            ge.getUsers().add(optUser.get());
            ge = groupRepository.save(ge);
            groupDTO = groupConverter.convertEntitytoDTO(Optional.of(ge));
        }
        return groupDTO;
    }

    @Override
    public void removeUserFromGroup(Long userId, UserDTO userDTO) {
        Optional<GroupEntity> optGroupEntity = groupRepository.findById(userDTO.getUserId());
        if(optGroupEntity.isPresent()){
            GroupEntity ge = optGroupEntity.get();
            ge.getUsers().remove(optGroupEntity.get());
            ge = groupRepository.save(ge);
        }
    }

    @Override
    public Optional<GroupDTO> findGroupById(Long groupId) {
        Optional<GroupEntity> optionalGroupEntity = groupRepository.findById(groupId);
        GroupDTO groupDTO = groupConverter.convertEntitytoDTO(optionalGroupEntity);
        return Optional.ofNullable(groupDTO);
    }

    @Override
    public List<UserEntity> findGroupUsers(Long id) {
        return null;
    }
}
