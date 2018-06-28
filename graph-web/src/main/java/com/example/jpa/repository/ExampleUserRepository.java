package com.example.jpa.repository;


import com.example.jpa.entity.ExampleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/6/14.
 */
@Repository
public interface ExampleUserRepository extends JpaRepository<ExampleUser, Long> {

    /**
     * 根据用户查询用户信息
     *
     * @param userName
     * @return
     */
    ExampleUser findByUserName(String userName);
}
