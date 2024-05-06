package org.example.jdbcc0124i1.service;

import org.example.jdbcc0124i1.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IGenerricService<T> {
    public void insert(T object) throws SQLException;

    public T selectById(int id);

    public List<T> selectAll();

    public boolean deleteById(int id) throws SQLException;

    public boolean update(T user) throws SQLException;
}
