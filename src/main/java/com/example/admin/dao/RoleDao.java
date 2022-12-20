package com.example.admin.dao;

import com.example.admin.entities.Role;
import com.example.admin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Long> {

    Role findByName(String name);

}
