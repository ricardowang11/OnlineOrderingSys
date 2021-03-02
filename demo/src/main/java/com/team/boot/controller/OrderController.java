package com.team.boot.controller;

import com.team.boot.bean.Order;
import com.team.boot.utils.ReturnMessage;
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
    public ReturnMessage deleteOrder(@PathVariable("id") int id) {
        return null;
    }

    //提交订单————————通过参数传递新建的order
    @PostMapping("/order")
    public ReturnMessage addOrder() {
        return null;
    }

    //    付款
    @GetMapping("/pay/{id}")
    public ReturnMessage pay(@PathVariable("id") int id) {
        return null;
    }

    //    订单送达
    @PutMapping("/arrive/{id}")
    public ReturnMessage arriveOrder(@PathVariable("id") int id) {
        return null;
    }
//    抢单

//    自动配单

//    ...

}
