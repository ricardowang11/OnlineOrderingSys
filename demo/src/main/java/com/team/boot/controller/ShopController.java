package com.team.boot.controller;

import com.team.boot.bean.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

/**
 * @Author: wangqin
 * @Date: 2021/3/1 0001 - 03 -01 -19:46
 * @Description: com.team.boot.controller
 * @version: 1.0
 */
@RestController
public class ShopController {
    //    按照名字查找商铺或者符合的物品
    @GetMapping("/item/{name}")
    public LinkedList<Shop> search(@PathVariable("name") String name) {
        return null;
    }

    //    添加商品————————参数传递
    @PostMapping("/item")
    public LinkedList<Shop> addItem() {
        return null;
    }

    //    下架商品
    @DeleteMapping("/item/{id}")
    public boolean deleteItem(@PathVariable("id") int id) {
        return false;
    }

    //    设置商品售空
    @PutMapping("/item/{id}")
    public boolean emptyItem(@PathVariable("id") int id) {
        return false;
    }

    //    更改商品价格
    @GetMapping("/item/{id}")
    public boolean updatePrice(@PathVariable("id") int id) {
        return false;
    }

}
