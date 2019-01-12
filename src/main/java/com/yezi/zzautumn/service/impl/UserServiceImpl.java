package com.yezi.zzautumn.service.impl;

import com.yezi.zzautumn.domain.User;
import com.yezi.zzautumn.repository.UserRepository;
import com.yezi.zzautumn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @Author: yezi
 * @Date: 2019/1/12 12 37
 * @Description:
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User checkUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        Example<User> example = Example.of(user);
        Optional<User> findUser = userRepository.findOne(example);

        return findUser.orElse(null);
    }

    @Override
    public User addUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return userRepository.save(user);
    }
}
