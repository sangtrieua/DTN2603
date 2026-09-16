package backend.service;

import entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getAccountS();

    boolean kiemTraTonTaiAccountId(Integer accountId);

    boolean suaUsernameTheoId(Integer accountId, String userName);

    boolean xoaAccountTheoId(Integer accountId);



    boolean themAccount(String email, String userName, String fullName, Integer departmentId, Integer positionId, String gender);

    boolean checkTonTaiEmail(String email);

    boolean checkTonTaiUserNameThem(String userName);

    boolean checkTonTaiUserNameSua(Integer accountId, String userName);
}
