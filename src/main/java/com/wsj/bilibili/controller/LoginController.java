package com.wsj.bilibili.controller;

import com.wsj.bilibili.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author wangshijian
 * @Description:
 * @date 2020/11/208:58 上午
 */
@Controller
public class LoginController {

    static {
        UserDTO user1 = new UserDTO("张三", "123456", 1);
        UserDTO user2 = new UserDTO("李四", "123456", 1);
        UserDTO user3 = new UserDTO("王五", "123456", 1);
    }

    @RequestMapping("login")
    public String loginPage(){
        return "login/login";
    }

    @RequestMapping("user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session,Model model){
        if (!StringUtils.isEmpty(username) && "123456".equalsIgnoreCase(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main";
        }

        model.addAttribute("msg","账号或密码错误");
        return "login/login";
    }
}
