package org.example.jdbcc0124i1.service.user;

import org.example.jdbcc0124i1.model.User;
import org.example.jdbcc0124i1.service.connect.GetConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {



    @Override
    public void insertUser(User user) throws SQLException {
        PreparedStatement preparedStatement = GetConnect.getConnection().prepareStatement("insert into users(name, email, country) values(?,?,?);");
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
            PreparedStatement preparedStatement = GetConnect.getConnection().prepareStatement("select * from users;");
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
