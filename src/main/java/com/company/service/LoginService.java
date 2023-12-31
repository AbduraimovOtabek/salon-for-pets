package com.company.service;

import com.company.model.User;
import com.company.role.RoleName;
import com.company.utils.CommonUtils;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

    private static LoginService loginService;

    public LoginService() {
    }

    public static LoginService getInstance() {
        if (loginService == null)
            loginService = new LoginService();
        return loginService;
    }

    @SneakyThrows
    public boolean login(User user) {

        Connection cn = CommonUtils.getConnection();

        PreparedStatement ps = cn.prepareStatement("SELECT COUNT(1) FROM users WHERE user_name = ? AND password = ?");
       
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getPassword());

        ResultSet rs = ps.executeQuery();

        rs.next();
        int countOfUsers = rs.getInt(1);

        if (countOfUsers == 0)
            return false;

        PreparedStatement ps2 = cn.prepareStatement("SELECT * FROM users WHERE user_name = ? AND password = ?");
        ps2.setString(1, user.getUserName());
        ps2.setString(2, user.getPassword());

        ResultSet rst = ps2.executeQuery();

        if (rst.next()) {
            user.setId(rst.getInt("user_id"));
            user.setName(rst.getString("name"));
            user.setUserName(rst.getString("user_name"));
            user.setRole(RoleName.valueOf(rst.getString("role_name")));
        }
        return true;
    }
}
