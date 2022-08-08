package com.ves.dao;

import com.ves.entity.Account;
import com.ves.entity.Garage;

import java.util.List;

public interface GarageDao {

    Garage get(int id);
    List<Garage> getAll();
    void delete(Garage test);
    void saveOrUpdate(Garage test);

    Garage get(Account account);

}
