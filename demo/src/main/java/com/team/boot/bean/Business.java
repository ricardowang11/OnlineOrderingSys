package com.team.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
public class Business {
    private int id;
    private String username;
    private String password;
    private String phone;
    //商家和骑手必须实名认证——————实名认证后添加realName属性，否则不允许申请开店（派送外卖）
    private String realName;
    //记录商户开的店铺
    private LinkedList<Integer> shops;
}
