package com.ves.service;

import com.ves.entity.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

public interface BoomService {


    void saveOrUpdate(BoomTruck boomTruck);
    void saveOrUpdate(Account account);

    @Transactional
    void saveOrUpdate(BoomDraggingVehicle vehicle);

    List<BoomTruck> getAllAvailable();
    List<BoomTruck> getAllNearAvailable(double latitude, double longitude);
    List<BoomTruck> getAllNearAvailable(String district);
    BoomTruck get(int id);
    BoomTruck get(Account account);
    BoomBoomingSession getSession(int id);

    HashMap<String, List<BoomBoomingSession>> getBoomingSessions(Account account);
    boolean requestSession(Account customer, BoomDraggingVehicle vehicle, BoomTruck truck);

    boolean approve(BoomBoomingSession session);
    boolean cancel(BoomBoomingSession session, boolean by_customer);
    boolean complete(BoomBoomingSession session);



}
