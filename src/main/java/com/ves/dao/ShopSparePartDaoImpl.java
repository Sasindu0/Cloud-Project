package com.ves.dao;

import com.ves.entity.ShopSparePart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopSparePartDaoImpl implements ShopSparePartDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public ShopSparePart get(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(ShopSparePart.class, id);
    }

    @Override
    public List<ShopSparePart> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<ShopSparePart> query = session.createQuery("FROM ShopSparePart", ShopSparePart.class);

        return query.getResultList();
    }

    @Override
    public List<ShopSparePart> search_part(String item) {
        Session session = sessionFactory.getCurrentSession();
        NativeQuery<ShopSparePart> query = session.createNativeQuery(String.format("SELECT * FROM `shop spare part` WHERE sp_name=\'%s\'",item), ShopSparePart.class);
        System.out.println("\n*************************** ShopSpareSearch ************************************\n");
        return query.getResultList();
    }

    @Override
    public void delete(ShopSparePart shop_sp) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(shop_sp);
    }

    @Override
    public void saveOrUpdate(ShopSparePart shop_sp) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(shop_sp);
    }
}
