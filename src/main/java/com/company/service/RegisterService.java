package com.company.service;

import com.company.model.User;
import com.company.utils.CommonUtils;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterService {

    private static RegisterService registerService;

    public RegisterService() {
    }

    public static RegisterService getInstance() {
        if (registerService == null) {
            registerService = new RegisterService();
        }
        return registerService;

    }

    @SneakyThrows
    public boolean register(User user) {
        Connection connection = CommonUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(1) FROM users WHERE user_name = ?");
        preparedStatement.setString(1, user.getUserName());

        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        int countOfUsers = resultSet.getInt(1);

        if (countOfUsers > 1) return false;

        PreparedStatement ps = connection.prepareStatement("INSERT INTO users(name,user_name,password) VALUES (?,?,?)");
        ps.setString(1, user.getName());
        ps.setString(2, user.getUserName());
        ps.setString(3, user.getPassword());
        ps.execute();

        return true;
    }
}
