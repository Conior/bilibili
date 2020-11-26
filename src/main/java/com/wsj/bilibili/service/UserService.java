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

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<UserDTO> getAllUser() {
        return userMapper.queryAllUser();
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
