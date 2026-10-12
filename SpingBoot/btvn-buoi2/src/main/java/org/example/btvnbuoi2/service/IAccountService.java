package org.example.btvnbuoi2.service;

import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.GroupAccount;

import java.util.List;

public interface IAccountService {

    List<Account> findAll();

    Account findById(Integer id);

    Account create(Account account);

    Account update(Integer id, Account account);

    void deleteById(Integer id);
}
