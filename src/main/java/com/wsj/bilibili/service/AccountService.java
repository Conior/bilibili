package com.wsj.bilibili.service;

/**
 * @author wangshijian
 * @Description:
 * @date 2020/11/2410:48 上午
 */

import com.wsj.bilibili.mapper.AccountMapper;
import com.wsj.bilibili.model.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;

    public Integer getAccount(AccountDTO accountDTO) {
        return accountMapper.queryAccount(accountDTO);
    }

    public Integer addAccount(AccountDTO accountDTO) {
        return accountMapper.insertAccount(accountDTO);
    }

    public Integer deleteAccountById(int id) {
        return accountMapper.deleteAccountById(id);
    }

    public Integer updateAccountById(AccountDTO accountDTO) {
        return accountMapper.updateAccountById(accountDTO);
    }
}
