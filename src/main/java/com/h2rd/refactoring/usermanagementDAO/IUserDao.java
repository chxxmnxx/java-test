/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.h2rd.refactoring.usermanagementDAO;

import com.h2rd.refactoring.usermanagement.User;
import java.util.ArrayList;

/**
 *
 * @author Amani
 */
public interface IUserDao {
    public void saveUser(User user);
    public ArrayList<User> getUsers();
    public void deleteUser(User userToDelete);
    public void updateUser(User userToUpdate);
    public User findUser(String name);
}
