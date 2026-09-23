package backend.service;

import entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getAccountS();

    boolean kiemTraTonTaiAccountId(Integer accountId);

    boolean suaUsernameTheoId(Integer accountId, String userName);

    boolean xoaAccountTheoId(Integer accountId);



    boolean themAccount(Account account);

    boolean checkTonTaiEmail(String email);

    boolean checkTonTaiUserNameThem(String userName);

    boolean checkTonTaiUserNameSua(Integer accountId, String userName);

    String importCSV(String url);
}
