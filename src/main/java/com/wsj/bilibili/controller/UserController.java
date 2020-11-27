package com.wsj.bilibili.controller;

import com.alibaba.fastjson.JSONObject;
import com.wsj.bilibili.model.UserDTO;
import com.wsj.bilibili.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangshijian
 * @Description:
 * @date 2020/11/208:58 上午
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("users")
    @ResponseBody
    public Map<String, Object> shouUsers(){
        List<UserDTO> allUser = null;

        Integer userCount = userService.getUserCount();
        allUser = userService.getAllUser();

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("code",0);
        dataMap.put("msg","ms");
        dataMap.put("count",userCount);
        dataMap.put("data",allUser);

        return dataMap;
    }


    @SneakyThrows
    @RequestMapping("user/add_user")
    public String addUser(HttpServletRequest request, HttpSession session, Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String address = province + "_" + city + "_" + district;
        String details = request.getParameter("details");
        Integer sex = Integer.parseInt(request.getParameter("sex"));
        String date = request.getParameter("birthday");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        if (!StringUtils.isEmpty(date)) {
            birthday = sdf.parse(date);
        }

        Integer user = userService.addUser(new UserDTO(null, username, password, email, phone, 0, birthday, address, sex,details));
        if (null != user && 0 != user) {
            model.addAttribute("msg","success");
        } else {
            model.addAttribute("msg","fail");
        }
        return "/user/user-add";
    }
}
