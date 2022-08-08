package com.ves.service;

import com.ves.dao.ShopSparePartDao;
import com.ves.entity.ShopSparePart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShopSparePartServiceImpl implements ShopSparePartService{

    @Autowired
    ShopSparePartDao shop_spDao;

    @Override
    @Transactional
    public ShopSparePart get(int id) {
        return shop_spDao.get(id);
    }

    @Override
    @Transactional
    public List<ShopSparePart> getAll() {
        return shop_spDao.getAll();
    }

    @Override
    @Transactional
    public List<ShopSparePart> search_part(String item) {
        return shop_spDao.search_part(item);
    }

    @Override
    @Transactional
    public void delete(ShopSparePart shop_sp) {
        shop_spDao.delete(shop_sp);
    }

    @Override
    @Transactional
    public void saveOrUpdate(ShopSparePart shop_sp) {
        shop_spDao.saveOrUpdate(shop_sp);
    }
}
