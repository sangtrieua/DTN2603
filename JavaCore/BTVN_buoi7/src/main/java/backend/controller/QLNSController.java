package backend.controller;

import backend.service.impl.QLNSServiceImpl;
import entity.Account;

import java.util.List;

public class QLNSController {
    private QLNSServiceImpl service;

    public QLNSController() {
        service = new QLNSServiceImpl();
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


    public boolean kiemTraTonTaiDepartmentId(Integer departmentId) {
        return service.kiemTraTonTaiDepartmentId(departmentId);
    }


    public boolean kiemTraTonTaiPostionId(Integer positionId) {
        return service.kiemTraTonTaiPostionId(positionId);
    }

    public boolean themAccount(String email, String userName, String fullName, Integer departmentId, Integer positionId, String gender) {
        return service.themAccount(email,userName,fullName,departmentId,positionId,gender);
    }
}
