package com.wsj.bilibili.controller;

import com.wsj.bilibili.model.UserDTO;
import com.wsj.bilibili.service.UserService;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public Map<String, Object> userList(HttpServletRequest request){
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String searchFiles = request.getParameter("searchFiles");

        int pageInt = Integer.parseInt(page);
        int dataCount = Integer.parseInt(limit);

        Map<String, Object> params = new HashMap<>();
        params.put("start", (pageInt - 1) * dataCount);
        params.put("dataCount", dataCount);
        if (StringUtils.isNotBlank(searchFiles)){
            params.put("searchFiles", "%" + searchFiles + "%");
        }

        Integer userCount = userService.getUserCount();
        List<UserDTO> allUser = userService.getUserByPage(params);

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

    @RequestMapping("deleteUser")
    @ResponseBody
    public Map<String, Object> deleteUser(HttpServletRequest request){
        Map<String, Object> dataMap = new HashMap<>();

        String userId = request.getParameter("userId");
        Integer deleteCount = userService.deleteUserById(Integer.parseInt(userId));
        if (0 == deleteCount){
            dataMap.put("code",204);
            dataMap.put("msg","未查找到该数据");
        } else {
            dataMap.put("code",200);
            dataMap.put("msg","删除成功");
        }

        return dataMap;
    }
}
