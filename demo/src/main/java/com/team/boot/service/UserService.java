package com.team.boot.service;

import com.team.boot.bean.User;
import com.team.boot.dao.UserDao;
import com.team.boot.utils.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wangqin
 * @Date: 2021/3/2 0002 - 03 -02 -16:48
 * @Description: com.team.boot.service
 * @version: 1.0
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public ReturnMessage checkUserWithNickName(String nickName,String password){
        User user = userDao.getUserWithNickName(nickName);

        ReturnMessage returnMessage=new ReturnMessage();
        if (user!=null&&user.getPassword().equals(password)){
            returnMessage.setSucceed(true);
        }else {
            returnMessage.setSucceed(false);
            returnMessage.setInfo("失败");
        }

        return returnMessage;
    }
    public int addUser(User user){
        int i = userDao.addUser(user);
        return i;
    }
}
