package org.example.btvnbuoi2.service.impl;

import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.GroupAccount;
import org.example.btvnbuoi2.repository.IAccountRepository;
import org.example.btvnbuoi2.repository.IGroupAccountRepository;
import org.example.btvnbuoi2.service.IAccountService;
import org.example.btvnbuoi2.service.IGroupAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
@Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Integer id, Account accountUpdate) {
        Account account1 = accountRepository.findById(id).orElse(null);
        if(account1==null){
            throw new RuntimeException("không tồn tại account id "+id);
        }
        else {
            account1.setUserName(accountUpdate.getUserName());
            account1.setEmail(accountUpdate.getEmail());
            account1.setFullName(accountUpdate.getFullName());
            account1.setDepartment(accountUpdate.getDepartment());
            account1.setPosition(accountUpdate.getPosition());
            account1.setCreateDate(accountUpdate.getCreateDate());
            return accountRepository.save(account1);
        }
    }

    @Override
    public void deleteById(Integer id) {
        Account account1 = accountRepository.findById(id).orElse(null);
        if(account1==null){
            throw new RuntimeException("không tồn tại account id "+id);
        }
        else {
            accountRepository.deleteById(id);
        }
    }
}
