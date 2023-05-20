package com.eraboy.usercrud.service.custom;

import com.eraboy.usercrud.dto.UserDto;

import java.util.List;

public interface UserService {
    public void saveUser(UserDto dto);
    public void deleteUser(long id);
    public void updateUser(UserDto dto);
    public UserDto searchUser(long id);
    public List<UserDto> getAllUser();
}
