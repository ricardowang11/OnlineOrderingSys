package com.team.boot.config;

import com.team.boot.dao.UserDao;
import com.team.boot.dao.UserDaoC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wangqin
 * @Date: 2021/3/2 0002 - 03 -02 -16:57
 * @Description: com.team.boot.config
 * @version: 1.0
 */
@Configuration
public class BeanConfig {
    @Bean
    public UserDao userDao(){
        return new UserDaoC();
    }
}
