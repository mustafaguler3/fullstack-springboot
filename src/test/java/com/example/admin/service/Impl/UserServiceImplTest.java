package com.example.admin.service.Impl;

import com.example.admin.dao.RoleDao;
import com.example.admin.dao.UserDao;
import com.example.admin.entities.Role;
import com.example.admin.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserDao userDao;
    @Mock
    private RoleDao roleDao;
    @Mock
    private User mockedUser;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void loadUserByEmail() {
        userService.loadUserByEmail("user1@hotmail.com");
        verify(userDao,times(1)).findByEmail(any());
    }

    @Test
    void createUser() {
        String email = "user@hotmail.com";
        String password = "123";
        User user = new User(email,password);

        userService.createUser(email,password);

        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userDao).save(argumentCaptor.capture());
        User capturedUser = argumentCaptor.getValue();

        assertEquals(user,capturedUser);

    }

    @Test
    void assignRoleToUser() {
        Role role = new Role();
        role.setRoleId(1L);

        when(userDao.findByEmail(any())).thenReturn(mockedUser);
        when(roleDao.findByName(any())).thenReturn(role);

        userService.assignRoleToUser("email@hotmail.com","123");

        verify(mockedUser,times(1)).assignRoleToUser(role);
    }
}
























