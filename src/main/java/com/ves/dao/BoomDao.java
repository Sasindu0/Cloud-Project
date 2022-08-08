package com.ves.dao;

import com.ves.entity.*;

import java.util.List;

public interface BoomDao {

    Account login(String username, String password);
    Account getAccount(int id);

    void saveOrUpdate(Account account);
    void saveOrUpdate(BoomTruck boomTruck);

    void saveOrUpdate(BoomDraggingVehicle vehicle);


    List<BoomTruck> getAllAvailable();
    List<BoomTruck> getAllNearAvailable(double latitude, double longitude);
    List<BoomTruck> getAllNearAvailable(String district);
    BoomTruck get(int id);
    BoomTruck get(Account account);
    BoomBoomingSession getSession(int id);

    List<BoomBoomingSession> getAllSessions(Account account);

    boolean requestSession(Account customer, BoomDraggingVehicle vehicle, BoomTruck truck);
    boolean approve(BoomBoomingSession session);
    boolean cancel(BoomBoomingSession session, boolean by_customer);

    List<BoomBoomingSession> getPendingSessions(Account account);

    boolean complete(BoomBoomingSession session);
}
