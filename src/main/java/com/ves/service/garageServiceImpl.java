package com.ves.service;

import com.ves.dao.GarageDao;
import com.ves.entity.Account;
import com.ves.entity.Garage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class garageServiceImpl implements GarageService {

    @Autowired
    GarageDao garageDao;

    @Override
    @Transactional
    public Garage get(int id) {
        return garageDao.get(id);
    }

    @Override@Transactional
    public Garage get(Account account) {
        return garageDao.get(account);
    }

    @Override
    @Transactional
    public List<Garage> getAll() {
        return garageDao.getAll();
    }

    @Override
    @Transactional
    public void delete(Garage test) {
        garageDao.delete(test);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Garage test) {
        garageDao.saveOrUpdate(test);
    }
}
