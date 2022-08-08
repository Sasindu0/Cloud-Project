package com.ves.service;

import com.ves.entity.Account;

import javax.transaction.Transactional;
import java.util.List;

public interface AccountService {

    @Transactional
    Account getLogin();

    @Transactional
    boolean register(Account account);

    @Transactional
    boolean login(String username, String password);

    @Transactional
    void logout();

    @Transactional
    Account getAccount(int id);

    Account get(int id);
    List<Account> getAll();
    Account get_acc(int id);
    void delete(Account shop);
    void saveOrUpdate(Account shop);

}
