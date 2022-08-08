package com.ves.service;

import com.ves.dao.AccountDao;
import com.ves.dao.BoomDao;
import com.ves.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;
    @Autowired
    BoomDao boomDao;

    @Autowired
    HttpSession httpSession;

    HashMap<String, Integer> accounts = new HashMap<>();

    @Override
    @Transactional
    public Account getLogin() {
        String id = httpSession.getId();

        if (id != null){
            Integer i = accounts.get(id);
            if (i != null){
                return getAccount(i);
            }
        }


        return null;
    }

    @Override
    @Transactional
    public boolean register(Account account) {
        try {
            boomDao.saveOrUpdate(account);
            accounts.put(httpSession.getId(), account.getRegisterId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    @Transactional
    public boolean login(String username, String password) {
        Account account = boomDao.login(username, password);

        if (account != null){
            accounts.put(httpSession.getId(), account.getRegisterId());
        }

        return account != null;
    }
    @Override
    @Transactional
    public void logout() {
        accounts.remove(httpSession.getId());
    }

    @Override
    @Transactional
    public Account getAccount(int id) {
        return boomDao.getAccount(id);
    }



    @Override
    @Transactional
    public Account get(int id) {
        return accountDao.get(id);
    }

    @Override
    @Transactional
    public List<Account> getAll() {
        return accountDao.getAll();
    }

    @Override
    @Transactional
    public Account get_acc(int id) {
        return accountDao.get_acc(id);
    }

    @Override
    @Transactional
    public void delete(Account account) {
        accountDao.delete(account);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Account account) {
        accountDao.saveOrUpdate(account);
    }
}
