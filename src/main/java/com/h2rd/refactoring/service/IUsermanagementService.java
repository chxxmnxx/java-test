/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.h2rd.refactoring.service;

import com.h2rd.refactoring.usermanagement.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amani
 */
public interface IUsermanagementService {
    public void addUser(String name,  String email, List<String> roles);
    public ArrayList<User> getUsers();
    public void deleteUser(String name,String email, List<String> roles);
    public void updateUser(String name,String email, List<String> roles);
    public User findUser(String name);
}
