package com.ves.dao;

import com.ves.entity.Account;
import com.ves.entity.Garage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GarageDaoImpl implements GarageDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Garage get(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Garage.class, id);
    }

    @Override
    public List<Garage> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Garage> query = session.createQuery("FROM Garage ", Garage.class);

        return query.getResultList();
    }

    @Override
    public void delete(Garage test) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(test);
    }

    @Override
    public void saveOrUpdate(Garage test) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(test);
    }

    @Override
    public Garage get(Account account) {
        Session session = sessionFactory.getCurrentSession();
        Query<Garage> query = session.createQuery("FROM Garage WHERE ownerId=:a", Garage.class);
        query.setParameter("a", account.getRegisterId());
        List<Garage> list = query.getResultList();
        if (list.size() == 0) return null;

        return list.get(0);
    }
}
