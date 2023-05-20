package com.eraboy.usercrud.service.custom.impl;

import com.eraboy.usercrud.dto.UserDto;
import com.eraboy.usercrud.entity.User;
import com.eraboy.usercrud.repo.UserRepo;
import com.eraboy.usercrud.service.custom.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveUser(UserDto dto) {
        if (userRepo.existsById(dto.getId())){
            userRepo.save(modelMapper.map(dto, User.class));
        }else{
            throw new RuntimeException("User is already exist, please enter the new user.");
        }
    }

    @Override
    public void deleteUser(long id) {
        if (userRepo.existsById(id)){
            userRepo.deleteById(id);
        }else{
            throw new RuntimeException("Please check the user id..");
        }
    }

    @Override
    public void updateUser(UserDto dto) {
        if (userRepo.existsById(dto.getId())){
            userRepo.save(modelMapper.map(dto, User.class));
        }else{
            throw new RuntimeException("No such user to update, Please check the id..");
        }
    }

    @Override
    public UserDto searchUser(long id) {
        if (userRepo.existsById(id)) {
            return modelMapper.map(userRepo.findById(id).get(), UserDto.class);
        }else{
            throw new RuntimeException("No User For" + id + "..");
        }
    }

    @Override
    public List<UserDto> getAllUser() {
        return null;
    }
}
