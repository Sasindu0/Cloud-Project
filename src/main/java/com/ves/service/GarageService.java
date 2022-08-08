package com.ves.service;

import com.ves.entity.Account;
import com.ves.entity.Garage;

import java.util.List;

public interface GarageService {

    Garage get(int id);
    Garage get(Account account);
    List<Garage> getAll();
    void delete(Garage test);
    void saveOrUpdate(Garage test);

}
