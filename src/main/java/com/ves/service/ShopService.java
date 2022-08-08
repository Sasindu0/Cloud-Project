package com.ves.service;

import com.ves.entity.Account;
import com.ves.entity.Shop;

import java.util.List;

public interface ShopService {

    Shop get(int id);
    List<Shop> getAll();
    List<Shop> search_shop(String item);
    void delete(Shop shop);
    void saveOrUpdate(Shop shop);

    Shop get(Account account);
}
