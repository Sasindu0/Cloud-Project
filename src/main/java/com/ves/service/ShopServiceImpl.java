package com.ves.service;

import com.ves.dao.ShopDao;
import com.ves.entity.Account;
import com.ves.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{

    @Autowired
    ShopDao shopDao;

    @Override
    @Transactional
    public Shop get(int id) {
        return shopDao.get(id);
    }

    @Override
    @Transactional
    public List<Shop> getAll() {
        return shopDao.getAll();
    }

    @Override
    @Transactional
    public List<Shop> search_shop(String item) {
        return shopDao.search_shop(item);
    }

    @Override
    @Transactional
    public void delete(Shop shop) {
        shopDao.delete(shop);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Shop shop) {
        shopDao.saveOrUpdate(shop);
    }

    @Override@Transactional
    public Shop get(Account account) {
        return shopDao.get(account);
    }
}
