package com.wsj.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wangshijian
 * @Description:
 * @date 2020/11/204:16 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Integer isDelete;
    private Date birthday;
    private String address;
    private Integer sex;
    private String details;
}
