package backend.controller;

import backend.service.IAccountService;
import backend.service.impl.AccountServiceImpl;
import entity.Account;

import java.util.List;

public class AccountController {
    private IAccountService service;

    public AccountController() {
        service = new AccountServiceImpl();
    }


    public List<Account> getAccountS() {
        return service.getAccountS();
    }


    public boolean kiemTraTonTaiAccountId(Integer accountId) {
        return service.kiemTraTonTaiAccountId(accountId);
    }


    public boolean suaUsernameTheoId(Integer accountId, String userName) {
    return service.suaUsernameTheoId(accountId,userName);
    }


    public boolean xoaAccountTheoId(Integer accountId) {
        return service.xoaAccountTheoId(accountId);
    }






    public boolean themAccount(Account account) {
        return service.themAccount(account);
    }

    public boolean checkTonTaiEmail(String email) {
        return service.checkTonTaiEmail(email);
    }

    public boolean checkTonTaiUserNameThem(String userName) {
        return service.checkTonTaiUserNameThem(userName);
    }

    public boolean checkTonTaiUserNameSua(Integer accountId, String userName) {
        return service.checkTonTaiUserNameSua(accountId,userName);
    }

    public String importCSV(String url) {
        return service.importCSV(url);
    }
}
