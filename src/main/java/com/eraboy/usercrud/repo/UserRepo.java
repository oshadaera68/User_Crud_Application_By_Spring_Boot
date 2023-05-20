package com.eraboy.usercrud.repo;

import com.eraboy.usercrud.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}
