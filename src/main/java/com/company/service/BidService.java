package com.company.service;

import com.company.model.Pet;
import com.company.utils.CommonUtils;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BidService {

    public static BidService bidService;

    public BidService() {
    }

    public static BidService getInstance() {
        if (bidService == null)
            bidService = new BidService();
        return bidService;
    }

    @SneakyThrows
    public boolean bid(Pet pet) {
        Connection connection = CommonUtils.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(1) FROM bid WHERE pat_name = ?;");
        preparedStatement.setString(1, pet.getPetName());

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int countOfPats = resultSet.getInt(1);
        if (countOfPats > 1)
            return false;

        PreparedStatement pst = connection.prepareStatement("INSERT INTO bid (pet, pet_name, service_name) VALUES(?,?,?);");
        pst.setString(1, pet.getPet());
        pst.setString(2, pet.getPetName());
        pst.setString(3, pet.getPetService());
        pst.execute();

        return true;

    }
}
