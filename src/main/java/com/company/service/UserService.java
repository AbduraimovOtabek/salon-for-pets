package com.company.service;

import com.company.model.User;
import com.company.utils.CommonUtils;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static UserService userService;

    public static UserService getInstance() {
        if (userService == null) {
            synchronized (UserService.class) {
                if (userService == null)
                    userService = new UserService();
            }
        }
        return userService;
    }

    @SneakyThrows
    public List<User> list() {
        List<User> users = new ArrayList<>();

        Connection connection = CommonUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

        while (resultSet.next()) {
            User user = User.builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .userName(resultSet.getString("userName"))
                    .build();
            users.add(user);
        }
        return users;
    }
}
