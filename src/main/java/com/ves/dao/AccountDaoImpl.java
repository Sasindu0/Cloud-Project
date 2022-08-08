package com.ves.dao;

import com.ves.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Account get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Account.class, id);
    }

    @Override
    public Account get_acc(int id) {
        Session session = sessionFactory.getCurrentSession();
        NativeQuery<Account> query = session.createNativeQuery("SELECT * FROM account WHERE `register id`="+id, Account.class);
        List<Account> accounts = query.getResultList();
        if(accounts.size() == 0) return null;

        return accounts.get(0);
    }

    @Override
    public List<Account> getAll() {
        Session session = sessionFactory.getCurrentSession();
        NativeQuery<Account> query = session.createNativeQuery("SELECT * FROM account", Account.class);
        return query.getResultList();
    }

    @Override
    public void delete(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(account);
    }

    @Override
    public void saveOrUpdate(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(account);
    }
}
