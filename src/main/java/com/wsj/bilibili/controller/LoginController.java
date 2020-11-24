package com.wsj.bilibili.controller;

import com.wsj.bilibili.model.AccountDTO;
import com.wsj.bilibili.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author wangshijian
 * @Description:
 * @date 2020/11/208:58 上午
 */
@Controller
public class LoginController {
    @Autowired
    AccountService accountService;

    @RequestMapping("login")
    public String loginPage(){
        return "login/login";
    }

    @RequestMapping("user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session,Model model){
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)){
            String userName = username.trim();
            String passWord = password.trim();

            Integer account = accountService.getAccount(new AccountDTO(null, userName, passWord, null, null));
            if (null != account && 0 != account) {
                session.setAttribute("loginUser", username);
                return "redirect:/main";
            }
        }

        model.addAttribute("msg","账号或密码错误");
        return "login/login";
    }

    @RequestMapping("user/signup")
    public String signup(HttpServletRequest request, HttpSession session, Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        Integer account = accountService.addAccount(new AccountDTO(null, username, password, email, phone));
        if (null != account && 0 != account) {
            session.setAttribute("loginUser", username);
            return "redirect:/main";
        }

        model.addAttribute("msg","账号创建失败");
        return "login/signup";
    }
}
