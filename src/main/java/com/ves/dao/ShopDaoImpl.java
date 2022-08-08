package com.ves.dao;

import com.ves.entity.Account;
import com.ves.entity.Shop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDaoImpl implements ShopDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Shop get(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Shop.class, id);
    }

    @Override
    public List<Shop> getAll() {
        Session session = sessionFactory.getCurrentSession();
        NativeQuery<Shop> query = session.createNativeQuery("SELECT * FROM Shop", Shop.class);
        return query.getResultList();
    }

    @Override
    public List<Shop> search_shop(String item) {
        Session session = sessionFactory.getCurrentSession();
        NativeQuery<Shop> query = session.createNativeQuery(String.format("SELECT * FROM Shop WHERE shop_name=\'%s\'",item), Shop.class);
        return query.getResultList();
    }



    @Override
    public void delete(Shop shop) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(shop);
    }

    @Override
    public void saveOrUpdate(Shop shop) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(shop);
    }

    @Override
    public Shop get(Account account) {
        Session session = sessionFactory.getCurrentSession();
        Query<Shop> query = session.createQuery("FROM Shop WHERE ownerId=:a", Shop.class);
        query.setParameter("a", account.getRegisterId());

        List<Shop> resultList = query.getResultList();
        if (resultList.size() == 0) return null;
        return resultList.get(0);
    }
}
