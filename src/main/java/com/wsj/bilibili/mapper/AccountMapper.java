package com.wsj.bilibili.mapper;

import com.wsj.bilibili.model.AccountDTO;
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
public interface AccountMapper {

    Integer queryAccount(AccountDTO accountDTO);

    Integer insertAccount(AccountDTO accountDTO);

    Integer deleteAccountById(Integer id);

    Integer updateAccountById(AccountDTO accountDTO);
}
