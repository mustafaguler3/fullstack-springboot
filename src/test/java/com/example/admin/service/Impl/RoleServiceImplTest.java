package com.example.admin.service.Impl;

import com.example.admin.dao.RoleDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {

    @Mock
    private RoleDao roleDao;
    @InjectMocks
    private RoleServiceImpl roleService;

    @Test
    void loadRoleByName() {
        roleService.loadRoleByName("ADMIN");
        verify(roleDao).findByName(any());
    }

    @Test
    void createRole() {
        roleService.createRole("ADMIN");
        verify(roleDao,times(1)).save(any());
    }
}
























