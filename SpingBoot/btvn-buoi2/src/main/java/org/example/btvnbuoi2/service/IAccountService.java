package org.example.btvnbuoi2.service;

import org.example.btvnbuoi2.dto.AccountDTO;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.GroupAccount;
import org.example.btvnbuoi2.form.AccountForm;

import java.util.List;

public interface IAccountService {

    List<AccountDTO> findAll();

    AccountDTO findById(Integer id);

    Account create(AccountForm accountForm);

    Account update(Integer id, AccountForm accountForm);

    void deleteById(Integer id);
}
