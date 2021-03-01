package com.team.boot.bean;

import com.team.boot.utils.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
public class Shop {
    private int id;
    private String name;
    private String pic;
    private Address address;

}
