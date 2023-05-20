package com.eraboy.usercrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDto {
    private long id;
    private String email;
    private String username;
    private String password;
    private String city;
}
