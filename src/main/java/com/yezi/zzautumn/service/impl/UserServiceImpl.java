package com.yezi.zzautumn.service.impl;

import com.yezi.zzautumn.domain.User;
import com.yezi.zzautumn.repository.UserRepository;
import com.yezi.zzautumn.service.UserService;
import com.yezi.zzautumn.utils.OperationResult;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Object checkUser(String name, String password) {
        Optional<User> findUser = userRepository.findByNameAndPassword(name, password);
        OperationResult result = new OperationResult(false);
        if (findUser.isPresent()) {
            result.setResult(true);
            result.setCode(OperationResult.CommonCodes.RESULT_OK);
            return result;
        } else {
            result.setCode(OperationResult.CommonCodes.GENERAL_FAIL);
            return result;
        }
    }

    @Override
    public User addUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return userRepository.save(user);
    }
}
