package org.example.jdbcc0124i1.service;

import org.example.jdbcc0124i1.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    public static final String URL = "jdbc:mysql://localhost:3306/c0124i1";
    public static final String USER = "root";
    public static final String PASSWORD = "123456@Abc";

    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("ket noi khong thanh cong");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("ket noi ko thanh cong");
            throw new RuntimeException(e);
        }
        System.out.println("ket noi thanh cong");
        return connection;

    }

    public static void main(String[] args) {
        UserDAO c = new UserDAO();
        Connection c1 = c.getConnection();
        List<User> userList = c.selectAllUsers();
        System.out.println(userList);
    }
    @Override
    public void insertUser(User user) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("insert into users(name, email, country) values(?,?,?);");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getCountry());
        preparedStatement.executeUpdate();
    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement("select * from users;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return false;
    }
}
