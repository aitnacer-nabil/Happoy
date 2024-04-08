package com.nabilaitnacer.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String userName;

    private String password;

}
