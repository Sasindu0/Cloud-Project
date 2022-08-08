package com.ves.dao;

import com.ves.entity.Account;

import java.util.List;

public interface AccountDao {

    Account get(int id);
    List<Account> getAll();
    Account get_acc(int id);
    void delete(Account account);
    void saveOrUpdate(Account account);

}
