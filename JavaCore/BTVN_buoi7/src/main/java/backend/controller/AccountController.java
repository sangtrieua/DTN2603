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






    public boolean themAccount(String email, String userName, String fullName, Integer departmentId, Integer positionId, String gender) {
        return service.themAccount(email,userName,fullName,departmentId,positionId,gender);
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
}
