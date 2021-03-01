package com.team.boot.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: wangqin
 * @Date: 2021/3/1 0001 - 03 -01 -19:32
 * @Description: com.team.boot.utils
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Destination {
    private Address address;
    private String addressee;
    private String phone;
    private DestinationStatus status=DestinationStatus.AUTO_GET;

    public Destination(Address address, String addressee, String phone) {
        this.address = address;
        this.addressee = addressee;
        this.phone = phone;
    }
}
