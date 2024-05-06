package org.example.jdbcc0124i1;

import org.example.jdbcc0124i1.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private Connection getConnection(){
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/c0124i1", "root", "123456@Abc");
            System.out.println("ket noi thanh cong");
            return c;
        } catch (SQLException e) {
            System.out.println("loi");
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Connection c = userManager.getConnection();
        List<User> userList = userManager.getAllUser();
//        System.out.println(userList);
    }

//    lay ra danh sach user
    public List<User> getAllUser(){
        List<User> userList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select *from users;");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                User user = new User(name, name, name);
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
}
