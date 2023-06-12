package com.company.utils;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonUtils {

    @SneakyThrows
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/salon_for_pets",
                "postgres",
                "2801"
        );
    }
}
