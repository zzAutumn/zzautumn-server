package com.yezi.zzautumn.repository;

import com.yezi.zzautumn.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: yezi
 * @Date: 2019/1/12 12 34
 * @Description:
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
