package com.wsj.bilibili.service;

/**
 * @author wangshijian
 * @Description:
 * @date 2020/11/2410:48 上午
 */

import com.wsj.bilibili.mapper.UserMapper;
import com.wsj.bilibili.model.AccountDTO;
import com.wsj.bilibili.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public Integer getUserCount(){
        return userMapper.queryUserCount();
    }

    public List<UserDTO> getAllUser() {
        return userMapper.queryAllUser();
    }

    public List<UserDTO> getUserByPage(Map<String, Object> params) {
        return userMapper.queryUserByPage(params);
    }

    public Integer getUserById(int id) {
        return userMapper.queryUserById(id);
    }

    public Integer addUser(UserDTO userDTO) {
        return userMapper.insertUser(userDTO);
    }

    public Integer deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }

    public Integer updateUserById(UserDTO userDTO) {
        return userMapper.updateUserById(userDTO);
    }
}
