package backend.repository;

import entity.Account;

import java.util.List;

public interface IAccountRepository {
    List<Account> getAccounts();

    boolean kiemTraTonTaiAccountId(Integer accountId);

    boolean suaUsernameTheoId(Integer accountId, String userName);

    boolean xoaAccountTheoId(Integer accountId);



    boolean themAccount(String email, String userName, String fullName, Integer departmentId, Integer positionId, String gender);

    boolean checkTonTaiEmail(String email);

    boolean checkTonTaiUserNameThem(String userName);

    boolean checkTonTaiUserNameSua(Integer accountId, String userName);
}
