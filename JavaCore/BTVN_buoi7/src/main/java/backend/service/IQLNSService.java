package backend.service;

import entity.Account;

import java.util.List;

public interface IQLNSService {
    List<Account> getAccountS();

    boolean kiemTraTonTaiAccountId(Integer accountId);

    boolean suaUsernameTheoId(Integer accountId, String userName);

    boolean xoaAccountTheoId(Integer accountId);

    boolean kiemTraTonTaiDepartmentId(Integer departmentId);

    boolean kiemTraTonTaiPostionId(Integer positionId);

    boolean themAccount(String email, String userName, String fullName, Integer departmentId, Integer positionId, String gender);
}
