package com.team.boot.controller;

import com.team.boot.bean.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

/**
 * @Author: wangqin
 * @Date: 2021/3/1 0001 - 03 -01 -19:45
 * @Description: com.team.boot.controller
 * @version: 1.0
 */
@RestController
public class DeliveryBoyController {
    //    获取该派送员送出的所有订单
    @GetMapping("/sends/{did}")
    public LinkedList<Order> getSends(@PathVariable("did") int did) {
        return null;
    }


}
