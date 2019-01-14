package com.yezi.zzautumn.service;

import com.yezi.zzautumn.domain.User;

/**
 * @Author: yezi
 * @Date: 2019/1/12 12 35
 * @Description:
 */
public interface UserService {
    Object checkUser(String name, String password);

    User addUser(String name, String password);
}
