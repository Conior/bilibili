package com.wsj.bilibili.mapper;

import com.wsj.bilibili.model.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangshijian
 * @Description:
 * @date 2020/11/249:55 上午
 */
@Mapper
@Repository
public interface UserMapper {
    List<UserDTO> queryAllUser();

    Integer queryUserById(Integer id);

    Integer insertUser(UserDTO userDTO);

    Integer deleteUserById(Integer id);

    Integer updateUserById(UserDTO userDTO);
}
