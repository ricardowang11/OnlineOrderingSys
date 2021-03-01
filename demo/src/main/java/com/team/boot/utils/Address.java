package com.team.boot.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: wangqin
 * @Date: 2021/3/1 0001 - 03 -01 -21:21
 * @Description: com.team.boot.utils
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    private String provinces;
    private String city;
    private String zone;
    private String details;
}
