package com.team.boot.dao;

import com.team.boot.bean.User;

/**
 * @Author: wangqin
 * @Date: 2021/3/1 0001 - 03 -01 -21:32
 * @Description: com.team.boot.dao
 * @version: 1.0
 */
public interface UserDao {
    int addUser(User user);
    User getUserWithNickName(String nickName);
}
