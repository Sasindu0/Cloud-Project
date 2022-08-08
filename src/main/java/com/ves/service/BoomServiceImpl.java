package com.ves.service;

import com.ves.dao.BoomDao;
import com.ves.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BoomServiceImpl implements BoomService{
    
    @Autowired
    BoomDao boomDao;

    @Override @Transactional
    public void saveOrUpdate(BoomTruck boomTruck) {
        boomDao.saveOrUpdate(boomTruck);
    }

    @Override @Transactional
    public void saveOrUpdate(Account account) {
        boomDao.saveOrUpdate(account);
    }

    @Override @Transactional
    public void saveOrUpdate(BoomDraggingVehicle vehicle) {
        boomDao.saveOrUpdate(vehicle);
    }

    @Override @Transactional
    public List<BoomTruck> getAllAvailable() {
        return boomDao.getAllAvailable();
    }

    @Override @Transactional
    public List<BoomTruck> getAllNearAvailable(double latitude, double longitude) {
        return boomDao.getAllNearAvailable(latitude, longitude);
    }

    @Override @Transactional
    public List<BoomTruck> getAllNearAvailable(String district) {
        return boomDao.getAllNearAvailable(district);
    }

    @Override @Transactional
    public BoomTruck get(int id) {
        return boomDao.get(id);
    }

    @Override @Transactional
    public BoomTruck get(Account account) {
        return boomDao.get(account);
    }

    @Override @Transactional
    public BoomBoomingSession getSession(int id) {
        return boomDao.getSession(id);
    }

    @Override @Transactional
    public HashMap<String, List<BoomBoomingSession>> getBoomingSessions(Account account) {
        List<BoomBoomingSession> un_approved = new ArrayList<>();
        List<BoomBoomingSession> expired = new ArrayList<>();
        List<BoomBoomingSession> on_going = new ArrayList<>();
        List<BoomBoomingSession> cancelled = new ArrayList<>();
        List<BoomBoomingSession> completed = new ArrayList<>();
        
        List<BoomBoomingSession> sessions = boomDao.getAllSessions(account);
        for (BoomBoomingSession session : sessions) {
            
            if (session.isCompleted()){
                completed.add(session);
                continue;
            }
            
            if (session.isExpired()){
                expired.add(session);
                continue;
            }
            
            if (session.isCancelled()){
                cancelled.add(session);
                continue;
            }
            
            if (!session.isAccepted()){
                un_approved.add(session);
                continue;
            }
            
            if (session.isOngoing()){
                on_going.add(session);
            }
            
            
        }

        HashMap<String, List<BoomBoomingSession>> sessionMap = new HashMap<>();
        sessionMap.put("expired", expired);
        sessionMap.put("on_going", on_going);
        sessionMap.put("cancelled", cancelled);
        sessionMap.put("completed", completed);
        sessionMap.put("un_approved", un_approved);

        return sessionMap;
    }

    @Override @Transactional
    public boolean requestSession(Account customer, BoomDraggingVehicle vehicle, BoomTruck truck) {
        return boomDao.requestSession(customer, vehicle, truck);
    }

    @Override @Transactional
    public boolean approve(BoomBoomingSession session) {
        return boomDao.approve(session);
    }

    @Override @Transactional
    public boolean cancel(BoomBoomingSession session, boolean by_customer) {
        return boomDao.cancel(session, by_customer);
    }

    @Override @Transactional
    public boolean complete(BoomBoomingSession session) {
        return boomDao.complete(session);
    }
}
