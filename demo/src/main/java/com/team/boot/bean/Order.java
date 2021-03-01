package com.team.boot.bean;

import com.team.boot.utils.Destination;
import com.team.boot.utils.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @Author: wangqin
 * @Date: 2021/3/1 0001 - 03 -01 -19:23
 * @Description: com.team.boot.bean
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    private int id;
//    点单用户id
    private int userId;
//    派送员id
    private int deliveryBoyId;
//    订单状态
    private OrderStatus status;
//    订单中物品信息
//    持久化时按照——————————shopId_itemId_itemNum+shopId_itemId_itemNum存储
    private LinkedHashMap<Item,Integer> items;
//    订单目的地
    private Destination destination;

}
