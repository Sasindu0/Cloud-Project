package com.ves.dao;

import com.ves.entity.Mechanic;

import java.util.List;

public interface MechanicDao {

    Mechanic get(int id);
    List<Mechanic> getAll();
    List<Mechanic> search_mechanic(String item);
    void delete(Mechanic mechanic);
    void saveOrUpdate(Mechanic mechanic);

}


