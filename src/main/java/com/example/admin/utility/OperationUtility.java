package com.example.admin.utility;

import com.example.admin.dao.UserDao;
import com.example.admin.entities.User;
import jakarta.persistence.EntityNotFoundException;

public class OperationUtility {

    public static void usersOperations(UserDao userDao){
        createUsers(userDao);
        fetchUsers(userDao);
        updateUser(userDao);
        deleteUser(userDao);
    }

    private static void createUsers(UserDao userDao){
        User user1 = new User();
        user1.setEmail("mustafa@hotmail.com");
        user1.setPassword("123");
        userDao.save(user1);

        User user2 = new User();
        user2.setEmail("mustafa2@hotmail.com");
        user2.setPassword("123");
        userDao.save(user2);
    }

    private static void updateUser(UserDao userDao){
        User user = userDao.findById(2L).orElseThrow(()->new EntityNotFoundException("User not found"));
        user.setEmail("new@hotmail.com");
        userDao.save(user);
    }

    private static void deleteUser(UserDao userDao){
        User user = userDao.findById(5L).orElseThrow(()->new EntityNotFoundException("User not found"));
        userDao.delete(user);
    }
    private static void fetchUsers(UserDao userDao){
        userDao.findAll().forEach(user -> System.out.println(user.toString()));
    }
}






















