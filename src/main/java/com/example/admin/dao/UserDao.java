package com.example.admin.dao;

import com.example.admin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {

    User findByEmail(String email);

}
