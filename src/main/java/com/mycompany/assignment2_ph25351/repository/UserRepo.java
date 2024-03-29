/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment2_ph25351.repository;

import com.mycompany.assignment2_ph25351.model.User;
import com.mycompany.assignment2_ph25351.service.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserRepo {
    private Connection connect = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    
    public List<User> select(){
        String sql = "SELECT * FROM USERS";

        List<User> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                User entity = new User();
                entity.setUsername(rs.getString(1));
                entity.setPassword(rs.getString(2));
                entity.setRole(rs.getString(3));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
