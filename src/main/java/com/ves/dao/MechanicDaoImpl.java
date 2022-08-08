package com.ves.dao;

import com.ves.entity.Mechanic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MechanicDaoImpl implements MechanicDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Mechanic get(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Mechanic.class, id);
    }

    @Override
    public List<Mechanic> getAll() {
        Session session = sessionFactory.getCurrentSession();
        NativeQuery<Mechanic> query = session.createNativeQuery("SELECT * FROM `Mechanic`", Mechanic.class);
        return query.getResultList();
    }

    @Override
    public List<Mechanic> search_mechanic(String item) {
        Session session = sessionFactory.getCurrentSession();

        NativeQuery<Mechanic> query = session.createNativeQuery(String.format("SELECT * FROM `Mechanic` WHERE mechanic_name=\'%s\'",item), Mechanic.class);
        return query.getResultList();
    }



    @Override
    public void delete(Mechanic mechanic) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(mechanic);
    }

    @Override
    public void saveOrUpdate(Mechanic mechanic) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("\n**************************MechanicDaoImpl save before*********************************\n");
        session.saveOrUpdate(mechanic);
        System.out.println("\n**************************MechanicDaoImpl save after*********************************\n");
    }
}
