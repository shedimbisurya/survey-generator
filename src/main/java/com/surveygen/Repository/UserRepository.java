package com.surveygen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.surveygen.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);

    User findByUsername(String username);

    User findByEmail(String email);

}
