package com.surveygen.Repository;

import com.surveygen.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {

    UserLogin findById(int id);

    UserLogin findByUsername(String username);

    UserLogin findByEmail(String email);

}
