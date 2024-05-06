package org.example.jdbcc0124i1.service.province;

import org.example.jdbcc0124i1.model.DTO.ProvinceDTO;
import org.example.jdbcc0124i1.model.Province;
import org.example.jdbcc0124i1.model.User;
import org.example.jdbcc0124i1.service.connect.GetConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProvinceService implements IProvinceService {


    @Override
    public void insert(Province object) throws SQLException {
        System.out.println("danh sach tinh");
        System.out.println("");
    }

    @Override
    public Province selectById(int id) {
        return null;
    }

    @Override
    public List<Province> selectAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Province user) throws SQLException {
        return false;
    }

    @Override
    public List<ProvinceDTO> getAll() {
        List<ProvinceDTO> provinces = new ArrayList<>();
        Connection c = GetConnect.getConnection();
        try {
            PreparedStatement preparedStatement = c.prepareStatement("select p.name, count(u.name) as number from province p  left join\n" +
                    "    c0124i1.users u on p.id = u.provine_id group by p.name;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int number = resultSet.getInt("number");
                ProvinceDTO p = new ProvinceDTO(name, number);
                provinces.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return provinces;
    }

    public static void main(String[] args) {
        ProvinceService p = new ProvinceService();
        List<ProvinceDTO> provinces = p.getAll();
        System.out.println(provinces);
    }
}
