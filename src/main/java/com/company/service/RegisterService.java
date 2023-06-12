package com.company.service;

import com.company.model.User;
import com.company.utils.CommonUtils;
import com.sun.jdi.connect.spi.Connection;

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

    public boolean register(User user) {
//        Connection connection = CommonUtils.getConnection() {
//
//        }
        return true;
    }
}
