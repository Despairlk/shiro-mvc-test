package com.fenger.service.impl;


import com.fenger.domain.User;
import com.fenger.domain.UserExample;
import com.fenger.mapper.UserMapper;
import com.fenger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public List<User> queryAllUser(User user) {
        UserExample userExample = new UserExample();
        return this.userMapper.selectByExample(userExample);
    }

    @Override
    public List<User> queryByUsername(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> list = this.userMapper.selectByExample(userExample);
        return list;
    }

    @Override
    public List<String> queryRoleByUserId(Integer userId) {

        return this.userMapper.queryRoleByUserId(userId);
    }

    @Override
    public List<String> queryPermissionByUserId(Integer userId) {
        return this.userMapper.queryPermissionByUserId(userId);

    }
}
