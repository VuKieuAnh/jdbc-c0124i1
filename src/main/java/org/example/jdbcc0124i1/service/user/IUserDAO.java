package org.example.jdbcc0124i1.service.user;

import org.example.jdbcc0124i1.model.User;
import org.example.jdbcc0124i1.service.IGenerricService;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO extends IGenerricService<User> {
    @Override
    default void insert(User object) throws SQLException {

    }

    @Override
    default User selectById(int id) {
        return null;
    }

    @Override
    default List<User> selectAll() {
        return null;
    }

    @Override
    default boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    default boolean update(User user) throws SQLException {
        return false;
    }

    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;
}
