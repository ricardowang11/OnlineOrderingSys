package com.team.boot.controller;

import com.team.boot.bean.Order;
import com.team.boot.bean.User;
import com.team.boot.service.UserService;
import com.team.boot.utils.Address;
import com.team.boot.utils.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;

/**
 * @Author: wangqin
 * @Date: 2021/3/1 0001 - 03 -01 -19:45
 * @Description: com.team.boot.controller
 * @version: 1.0
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    //    获取该用户送出的所有订单
    @GetMapping("/buy/{uid}")
    public LinkedList<Order> getSends(@PathVariable("uid") int uid) {
        return null;
    }

    //    新增地址——————通过参数传递新增的地址
    @PostMapping("/address")
    public ReturnMessage addAddress() {
        return null;
    }

    //    删除地址——————通过参数传递删除的地址
    @DeleteMapping("/address/{index}")
    public ReturnMessage deleteAddress(@PathVariable("index") int index) {
        return null;
    }

    //    更新地址——————通过参数传递更新的地址
    @PutMapping("/address/{index}")
    public ReturnMessage updateAddress(@PathVariable("index") int index) {
        return null;
    }

    //    查看地址
    @GetMapping("/address/{index}")
    public ReturnMessage getAddress(@PathVariable("index") int index) {
        return null;
    }

    //    获取目标地址————————如果没设置默认地址，则通过ip地址获取
    @GetMapping("/currentAddress")
    public Address getCurrentAddress(HttpServletRequest request) {
        return null;
    }

    //    更新目标地址————————通过参数传递新的临时地址
    @PutMapping("/currentAddress")
    public ReturnMessage updateCurrentAddress() {
        return null;
    }
    //    密码丢失
    @PutMapping("/resetpass")
    public ReturnMessage resetPass() {
        return null;
    }

    //    注册用户
    @GetMapping("/signup/user")
    public ReturnMessage signupUser(User user) {
        int i = userService.addUser(user);
        ReturnMessage returnMessage=new ReturnMessage();
        if (i == 1) {
            returnMessage.setSucceed(true);
        }
        returnMessage.setSucceed(false);
        return returnMessage;
    }
    //    登录
    @GetMapping("/signin/user")
    public ReturnMessage signinUser(HttpSession session,@RequestParam("username") String username,@RequestParam("password") String password) {
        ReturnMessage returnMessage = userService.checkUserWithNickName(username, password);
        if (returnMessage.isSucceed()){
            session.setAttribute("user",new User());
        }

        return returnMessage;
    }

    //    申请商家用户
    @PostMapping("/signup/business")
    public ReturnMessage logupBusiness() {
        return null;
    }
    //    登录
    @RequestMapping("/signin/business")
    public ReturnMessage signinBusiness() {
        return null;
    }

    //    申请成为骑手
    @PostMapping("/signup/delivery")
    public ReturnMessage logupDeliveryBoy() {
        return null;
    }
    //    登录
    @RequestMapping("/signin/delivery")
    public ReturnMessage signinDeliveryBoy() {
        return null;
    }

    @DeleteMapping("/signout/user")
    public ReturnMessage signoutUser(HttpSession session) {
        session.removeAttribute("user");
        return null;
    }


    @RequestMapping("/confirm")
    public ReturnMessage confirm(HttpServletRequest request){
        Object user = request.getSession().getAttribute("user");
        System.out.println(user);
        ReturnMessage returnMessage=new ReturnMessage();

        if (user==null){
            returnMessage.setSucceed(false);
            return returnMessage;
        }
        returnMessage.setSucceed(true);
        return returnMessage;
    }
    @GetMapping("/user/current")
    public User getCurrentUser(HttpSession session){

        User user = (User) session.getAttribute("user");

        return user;
    }
}
