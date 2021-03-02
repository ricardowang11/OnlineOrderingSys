package com.team.boot.dao;

import com.team.boot.bean.User;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: wangqin
 * @Date: 2021/3/2 0002 - 03 -02 -16:50
 * @Description: com.team.boot.dao
 * @version: 1.0
 */
public class UserDaoC implements UserDao{
    private static ConcurrentHashMap<String,User> users=new ConcurrentHashMap<>();
    @Override
    public int addUser(User user) {
        user.setId(users.size());
        User u = users.get(user.getUsername());
        if (u!=null){
            return 0;
        }
        users.put(user.getUsername(),user);
        return 1;
    }

    @Override
    public User getUserWithNickName(String nickName) {
        User user = users.get(nickName);
        return user;
    }
}
