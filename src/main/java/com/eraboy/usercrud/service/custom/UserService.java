package com.eraboy.usercrud.service.custom;

import com.eraboy.usercrud.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public void saveUser(User user);
    public void deleteUser(long id);
    public void updateUser(User user);
    public List<User> getAllUser();

    public Optional<User> searchUser(long id);
}
