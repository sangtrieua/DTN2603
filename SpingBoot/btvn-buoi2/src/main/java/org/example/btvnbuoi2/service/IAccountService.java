package org.example.btvnbuoi2.service;

import org.example.btvnbuoi2.dto.AccountDTO;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.GroupAccount;
import org.example.btvnbuoi2.form.AccountForm;
import org.example.btvnbuoi2.form.AccountSearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {

    Page<AccountDTO> findAll(AccountSearchForm searchForm, Pageable pageable);

    AccountDTO findById(Integer id);

    Account create(AccountForm accountForm);

    Account update(Integer id, AccountForm accountForm);

    void deleteById(Integer id);
}
