package com.team.boot.controller;

import com.team.boot.bean.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;

/**
 * @Author: wangqin
 * @Date: 2021/3/1 0001 - 03 -01 -19:45
 * @Description: com.team.boot.controller
 * @version: 1.0
 */
@RestController
public class UserController {
    //    获取该用户送出的所有订单
    @GetMapping("/buy/{uid}")
    public LinkedList<Order> getSends(@PathVariable("uid") int uid) {
        return null;
    }

    //    新增地址——————通过参数传递新增的地址
    @PostMapping("/address")
    public boolean addAddress() {
        return false;
    }

    //    删除地址——————通过参数传递删除的地址
    @DeleteMapping("/address/{index}")
    public boolean deleteAddress(@PathVariable("index") int index) {
        return false;
    }

    //    更新地址——————通过参数传递更新的地址
    @PutMapping("/address/{index}")
    public boolean updateAddress(@PathVariable("index") int index) {
        return false;
    }

    //    查看地址
    @GetMapping("/address/{index}")
    public boolean getAddress(@PathVariable("index") int index) {
        return false;
    }

    //    获取目标地址————————如果没设置默认地址，则通过ip地址获取
    @GetMapping("/currentAddress")
    public boolean getCurrentAddress(HttpServletRequest request) {
        return false;
    }

    //    更新目标地址————————通过参数传递新的临时地址
    @PutMapping("/currentAddress")
    public boolean updateCurrentAddress() {
        return false;
    }

    //    注册用户
    @PostMapping("/logup/user")
    public boolean logupUser() {
        return false;
    }

    //    密码丢失
    @PutMapping("/resetpass")
    public boolean resetPass() {
        return false;
    }

    //    申请商家用户
    @PostMapping("/logup/business")
    public boolean logupBusiness() {
        return false;
    }

    //    申请成为骑手
    @PostMapping("/logup/delivery")
    public boolean logupDeliveryBoy() {
        return false;
    }
}
