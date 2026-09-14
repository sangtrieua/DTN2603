package backend.service.impl;

import backend.repository.IQLNSRepository;
import backend.repository.impl.QLNSReponsitoryImpl;
import backend.service.IQLNSService;
import entity.Account;

import java.util.List;

public class QLNSServiceImpl implements IQLNSService {
    IQLNSRepository reponsitory;

    public QLNSServiceImpl() {
        reponsitory = new QLNSReponsitoryImpl();
    }

    @Override
    public List<Account> getAccountS() {
        return reponsitory.getAccounts();
    }

    @Override
    public boolean kiemTraTonTaiAccountId(Integer accountId) {
        return reponsitory.kiemTraTonTaiAccountId(accountId);
    }

    @Override
    public boolean suaUsernameTheoId(Integer accountId, String userName) {
        return reponsitory.suaUsernameTheoId(accountId,userName);
    }

    @Override
    public boolean xoaAccountTheoId(Integer accountId) {
        return reponsitory.xoaAccountTheoId(accountId);
    }

    @Override
    public boolean kiemTraTonTaiDepartmentId(Integer departmentId) {
        return reponsitory.kiemTraTonTaiDepartmentId(departmentId);
    }

    @Override
    public boolean kiemTraTonTaiPostionId(Integer positionId) {
        return reponsitory.kiemTraTonTaiPostionId(positionId);
    }

    @Override
    public boolean themAccount(String email, String userName, String fullName, Integer departmentId, Integer positionId, String gender) {
        return reponsitory.themAccount(email,userName,fullName,departmentId,positionId,gender);
    }
}
