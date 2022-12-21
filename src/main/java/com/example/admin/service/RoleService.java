package com.example.admin.service;

import com.example.admin.entities.Role;

public interface RoleService {

    Role loadRoleByName(String roleName);

    Role createRole(String roleName);
}
