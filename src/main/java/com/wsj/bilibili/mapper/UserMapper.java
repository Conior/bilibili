package com.wsj.bilibili.mapper;

import com.wsj.bilibili.model.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author wangshijian
 * @Description:
 * @date 2020/11/249:55 上午
 */
@Mapper
@Repository
public interface UserMapper {
    Integer queryUserCount();

    List<UserDTO> queryAllUser();

    List<UserDTO> queryUserByPage(Map<String, Object> params);

    Integer queryUserById(Integer id);

    Integer insertUser(UserDTO userDTO);

    Integer deleteUserById(Integer id);

    Integer updateUserById(UserDTO userDTO);
}
