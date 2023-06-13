package com.company.model;

import com.company.role.RoleName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User {
    private int id;

    private String name;

    private String userName;

    private String password;

//    private String passwordConfirm;

    private RoleName role;

}
