package com.example.jdbc;

import com.example.jpa.entity.ExampleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by merit on 2018/2/7.
 */
@Service
public class ExampleJdbcService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ExampleUser> findExampleUserByName(String userName) {
        String querySql = "SELECT ID,PASSWORD,USER_NAME,CREDENTIALS_SALT FROM PF_USER_INFO WHERE USER_NAME = '" + userName + "'";
        List<ExampleUser> users = jdbcTemplate.query(querySql, new RowMapper<ExampleUser>() {
            @Override
            public ExampleUser mapRow(ResultSet resultSet, int i) throws SQLException {
                ExampleUser user = new ExampleUser();
                user.setId(resultSet.getString("ID"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setUserName(resultSet.getString("USER_NAME"));
                user.setCredentialsSalt(resultSet.getString("CREDENTIALS_SALT"));
                return user;
            }
        });

        return users;
    }
}
