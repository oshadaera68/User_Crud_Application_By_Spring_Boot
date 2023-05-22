package com.eraboy.usercrud.service.custom.impl;

import com.eraboy.usercrud.entity.User;
import com.eraboy.usercrud.repo.UserRepo;
import com.eraboy.usercrud.service.custom.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the user id..");
        }
    }

    @Override
    public void updateUser(User user) {
        if (userRepo.existsById(user.getId())) {
            userRepo.save(user);
        } else {
            throw new RuntimeException("No such user to update, Please check the id..");
        }
    }

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public Optional<User> searchUser(long id) {
        return userRepo.findById(id);
    }
}
