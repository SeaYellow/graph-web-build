package com.authority.jpa.repository;


import com.authority.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/6/14.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据用户查询用户信息
     *
     * @param userName
     * @return
     */
    User findByUserName(String userName);
}
