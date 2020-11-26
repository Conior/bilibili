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
public class AccountDTO {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Integer isDelete;
}
