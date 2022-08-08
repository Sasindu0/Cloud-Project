package com.ves.service;

import com.ves.dao.MechanicDao;
import com.ves.entity.Mechanic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MechanicServiceImpl implements MechanicService{

    @Autowired
    MechanicDao mechanicDao;

    @Override
    @Transactional
    public Mechanic get(int id) {
        return mechanicDao.get(id);
    }

    @Override
    @Transactional
    public List<Mechanic> getAll() {
        return mechanicDao.getAll();
    }

    @Override
    @Transactional
    public List<Mechanic> search_mechanic(String item) {
        return mechanicDao.search_mechanic(item);
    }

    @Override
    @Transactional
    public void delete(Mechanic mechanic) {
        mechanicDao.delete(mechanic);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Mechanic mechanic) {
        System.out.println("\n**************************MechanicServiceImpl save*********************************\n");
        mechanicDao.saveOrUpdate(mechanic);
        
    }
}
