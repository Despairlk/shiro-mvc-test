package com.fenger.service;

import com.fenger.domain.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Integer userId);
    List<User> queryAllUser(User user);
    List<User> queryByUsername(String username);

    List<String> queryRoleByUserId(Integer userId);

    List<String> queryPermissionByUserId(Integer userId);
}
