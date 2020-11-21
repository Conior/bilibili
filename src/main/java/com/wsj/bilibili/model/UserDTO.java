package com.wsj.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangshijian
 * @Description:
 * @date 2020/11/204:16 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String name;
    private String password;
    private Integer gender;
}
