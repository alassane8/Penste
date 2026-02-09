package com.example.penste.user.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestBody {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
