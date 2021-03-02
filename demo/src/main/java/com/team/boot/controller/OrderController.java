package com.team.boot.controller;

import com.team.boot.bean.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: wangqin
 * @Date: 2021/3/1 0001 - 03 -01 -19:47
 * @Description: com.team.boot.controller
 * @version: 1.0
 */
@RestController
public class OrderController {
    //    取消某个订单
    @DeleteMapping("order/{id}")
    public boolean deleteOrder(@PathVariable("id") int id) {
        return false;
    }

    //提交订单————————通过参数传递新建的order
    @PostMapping("/order")
    public boolean addOrder() {
        return false;
    }

    //    付款
    @GetMapping("/pay/{id}")
    public boolean pay(@PathVariable("id") int id) {
        return false;
    }

    //    订单送达
    @PutMapping("/arrive/{id}")
    public boolean arriveOrder(@PathVariable("id") int id) {
        return false;
    }
//    抢单

//    自动配单

//    ...

}
