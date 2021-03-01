package com.team.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedList;

/**
 * @Author: wangqin
 * @Date: 2021/3/1 0001 - 03 -01 -19:22
 * @Description: com.team.boot.bean
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeliveryBoy {
    private int id;
    private String username;
    private String password;
    private String phone;
//    骑手负责区域
    private String address;
    //商家和骑手必须实名认证——————实名认证后添加realName属性，否则不允许申请开店（派送外卖）
    private String realName;
//    骑手当前接到的订单————————利用redis添加持久化手段
    private LinkedList<Order> orders;

}
