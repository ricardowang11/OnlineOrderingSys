package com.team.boot.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: wangqin
 * @Date: 2021/3/2 0002 - 03 -02 -15:58
 * @Description: com.team.boot.utils
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReturnMessage {
    private boolean isSucceed;
    private String info;
    /*
    {
        "isSucceed":"你写的值"
        "info":"你写的值"
    }
     */
}
