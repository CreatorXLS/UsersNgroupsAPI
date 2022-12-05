package com.groups.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GroupEntity {

    @Id
    @GeneratedValue
    private Long groupId;

    private String groupName;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.PERSIST
                    },
            targetEntity = UserEntity.class)
    @JoinTable(name = "USERS_IN_GROUPS",
            joinColumns = @JoinColumn(name = "USER_ID",
                    nullable = false,
                    updatable = false),
            inverseJoinColumns = @JoinColumn(name = "GROUP_ID",
                    nullable = false,
                    updatable = false),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private List<UserEntity> users = new ArrayList<>();


}
