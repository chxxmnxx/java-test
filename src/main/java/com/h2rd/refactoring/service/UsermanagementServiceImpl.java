/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.h2rd.refactoring.service;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.usermanagementDAO.IUserDao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amani
 */
@Service
public class UsermanagementServiceImpl implements IUsermanagementService{

    @Autowired
    IUserDao userDao;
    
    public void addUser(String name, String email, List<String> roles) {
       User user = new User(name, email, roles);
       userDao.saveUser(user);
    
    }

    public ArrayList<User> getUsers() {
        return userDao.getUsers();
    }

    public void deleteUser(String name, String email, List<String> roles) {
        User user = new User(name, email, roles);
        userDao.deleteUser(user);
    }

    public void updateUser(String name, String email, List<String> roles) {
        User user = new User(name, email, roles);
        userDao.updateUser(user);
    }

    public User findUser(String name) {
        return userDao.findUser(name);
    }
    
}
