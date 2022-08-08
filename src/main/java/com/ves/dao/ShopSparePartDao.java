package com.ves.dao;

import com.ves.entity.ShopSparePart;

import java.util.List;

public interface ShopSparePartDao {

    ShopSparePart get(int id);
    List<ShopSparePart> getAll();
    List<ShopSparePart> search_part(String item);
    void delete(ShopSparePart shop_sp);
    void saveOrUpdate(ShopSparePart shop_sp);

}
