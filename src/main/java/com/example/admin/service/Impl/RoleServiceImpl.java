package com.example.admin.service.Impl;

import com.example.admin.dao.RoleDao;
import com.example.admin.entities.Role;
import com.example.admin.service.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role loadRoleByName(String roleName) {
        return roleDao.findByName(roleName);
    }

    @Override
    public Role createRole(String roleName) {
        Role role = new Role();
        role.setName(roleName);
        return roleDao.save(role);
    }
}
