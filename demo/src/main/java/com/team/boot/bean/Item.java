package com.team.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedList;

/**
 * @Author: wangqin
 * @Date: 2021/3/1 0001 - 03 -01 -19:25
 * @Description: com.team.boot.bean
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    private int id;

    private String name;
//    商品价格
    private float price;
    //    商家id
    private int shopId;
//    商品图片
    private String pic;
//    商品评分
    private float score;
//    商品评价
    private LinkedList<String> comments;

}
