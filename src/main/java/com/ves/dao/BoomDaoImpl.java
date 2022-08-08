package com.ves.dao;

import com.ves.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoomDaoImpl implements BoomDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Account login(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query<Account> query = session.createQuery("FROM Account WHERE username=:a AND password=:b", Account.class);
        query.setParameter("a", username);
        query.setParameter("b", password);

        List<Account> list = query.getResultList();
        if (list.size() == 0) return null;
        return list.get(0);
    }

    @Override
    public Account getAccount(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Account.class, id);
    }

    @Override
    public void saveOrUpdate(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(account);
    }

    @Override
    public void saveOrUpdate(BoomTruck boomTruck) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(boomTruck);
    }

    @Override
    public void saveOrUpdate(BoomDraggingVehicle vehicle) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(vehicle);

    }

    @Override
    public List<BoomTruck> getAllAvailable() {
        Session session = sessionFactory.getCurrentSession();
        Query<BoomTruck> query = session.createQuery("FROM BoomTruck WHERE available=:a", BoomTruck.class);
        query.setParameter("a", true);
        return query.getResultList();
    }

    @Override
    public List<BoomTruck> getAllNearAvailable(double latitude,
                                               double longitude) {
        Session session = sessionFactory.getCurrentSession();


        Query<BoomTruck> query = session.createQuery("FROM BoomTruck BT WHERE " +
                "BT.available=:available AND BT.latitude IS NOT NULL AND BT.longitude IS NOT NULL " +
                "ORDER BY SQRT(POW((BT.latitude - :lat), 2) + POW((BT.longitude - :lon), 2))", BoomTruck.class);
        query.setParameter("available", true);
        query.setParameter("lon", longitude);
        query.setParameter("lat", latitude);

        return query.getResultList();
    }

    @Override
    public List<BoomTruck> getAllNearAvailable(String district) {
        Session session = sessionFactory.getCurrentSession();



        return null;
    }

    @Override
    public BoomTruck get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(BoomTruck.class, id);
    }

    @Override
    public BoomTruck get(Account account) {
        Session session = sessionFactory.getCurrentSession();
        Query<BoomTruck> query = session.createQuery("FROM BoomTruck BT WHERE BT.driverId=:a", BoomTruck.class);
        query.setParameter("a", account.getRegisterId());

        List<BoomTruck> trucks = query.getResultList();
        if (trucks.size() == 0) return null;

        return trucks.get(0);
    }

    @Override
    public BoomBoomingSession getSession(int id) {
        Session session = sessionFactory.getCurrentSession();


        return session.get(BoomBoomingSession.class, id);
    }

    @Override
    public List<BoomBoomingSession> getAllSessions(Account account) {
        Session session = sessionFactory.getCurrentSession();
        Query<BoomBoomingSession> query = session.createQuery(
                "FROM BoomBoomingSession WHERE customerId=:a OR truck.driverId=:a",
                BoomBoomingSession.class);
        query.setParameter("a", account.getRegisterId());

        return query.getResultList();
    }


    @Override
    public boolean requestSession(Account customer, BoomDraggingVehicle vehicle, BoomTruck truck) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(vehicle);
        BoomBoomingSession boomingSession = new BoomBoomingSession(
                customer.getRegisterId(), truck.getId(), false, false, vehicle.getId(), false);
        session.saveOrUpdate(boomingSession);
        return true;
    }

    @Override
    public boolean approve(BoomBoomingSession s) {
        Session session = sessionFactory.getCurrentSession();
        s.setDriverAccepted(true);
        session.saveOrUpdate(s);
        return true;
    }

    @Override
    public boolean cancel(BoomBoomingSession s, boolean by_customer) {
        Session session = sessionFactory.getCurrentSession();
        if (by_customer) s.setCustomerCancelled(true);
        else {
            s.setDriverAccepted(false);
            s.setDriverCancelled(true);
        }
        session.saveOrUpdate(s);
        return true;

    }

    @Override
    public List<BoomBoomingSession> getPendingSessions(Account account) {
        Session session = sessionFactory.getCurrentSession();
        Query<BoomBoomingSession> query;

        query = session.createNativeQuery("SELECT * FROM `boom booming session`\n" +
                "         WHERE completed = FALSE AND\n" +
                "               customer = :a AND \n" +
                "               `customer cancelled` = FALSE AND\n" +
                "               `driver accepted` = FALSE AND\n" +
                "               `driver cancelled` = FALSE " /*+"AND\n"*/ +
//                "               NOW() > DATE_ADD(`time requested`, INTERVAL 3 HOUR)\n" +
                "ORDER BY NOW() - `time requested` DESC;", BoomBoomingSession.class);

        query.setParameter("a", account.getRegisterId());

        return query.getResultList();

    }

    @Override
    public boolean complete(BoomBoomingSession s) {
        Session session = sessionFactory.getCurrentSession();
        s.setCompleted(true);
        session.saveOrUpdate(s);
        return true;
    }
}
