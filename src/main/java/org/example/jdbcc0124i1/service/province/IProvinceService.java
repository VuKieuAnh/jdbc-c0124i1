package org.example.jdbcc0124i1.service.province;

import org.example.jdbcc0124i1.model.DTO.ProvinceDTO;
import org.example.jdbcc0124i1.model.Province;
import org.example.jdbcc0124i1.model.User;
import org.example.jdbcc0124i1.service.IGenerricService;

import java.sql.SQLException;
import java.util.List;

public interface IProvinceService extends IGenerricService<Province> {
    List<ProvinceDTO> getAll();
}
