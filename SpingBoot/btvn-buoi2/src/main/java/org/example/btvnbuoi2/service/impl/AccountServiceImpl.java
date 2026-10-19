package org.example.btvnbuoi2.service.impl;

import org.example.btvnbuoi2.config.ModelMapperConfig;
import org.example.btvnbuoi2.dto.AccountDTO;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.Department;
import org.example.btvnbuoi2.entity.GroupAccount;
import org.example.btvnbuoi2.entity.Position;
import org.example.btvnbuoi2.enums.PositionName;
import org.example.btvnbuoi2.exception.BusinessException;
import org.example.btvnbuoi2.form.AccountForm;
import org.example.btvnbuoi2.form.AccountSearchForm;
import org.example.btvnbuoi2.repository.IAccountRepository;
import org.example.btvnbuoi2.repository.IDepartmentRepository;
import org.example.btvnbuoi2.repository.IGroupAccountRepository;
import org.example.btvnbuoi2.repository.IPositionRepository;
import org.example.btvnbuoi2.service.IAccountService;
import org.example.btvnbuoi2.service.IGroupAccountService;
import org.example.btvnbuoi2.specification.AccountCustomSepcification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IDepartmentRepository departmentRepository;
    @Autowired
    private IPositionRepository positionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Page<AccountDTO> findAll(AccountSearchForm searchForm, Pageable pageable) {
        Specification<Account> where = Specification.unrestricted();
        if (searchForm.getUserName() != null) {
            AccountCustomSepcification userNameSearchForm = new AccountCustomSepcification("userName",searchForm.getUserName());
            where=where.and(userNameSearchForm);
        }
        if (searchForm.getEmail() != null) {
            AccountCustomSepcification emailSearchForm = new AccountCustomSepcification("email",searchForm.getEmail());
            where=where.and(emailSearchForm);
        }
        if (searchForm.getDepName() != null) {
            AccountCustomSepcification depNameSearchForm = new AccountCustomSepcification("depName",searchForm.getDepName());
            where=where.and(depNameSearchForm);
        }
        if (searchForm.getPosName() != null) {
            AccountCustomSepcification posNameSearchForm = new AccountCustomSepcification("posName",searchForm.getPosName());
            where=where.and(posNameSearchForm);
        }



        Page<Account> accounts=  accountRepository.findAll(where,pageable);

        return accounts.map(account->modelMapper.map(account,AccountDTO.class));
    }

    @Override
    public AccountDTO findById(Integer id) {
        return modelMapper.map(accountRepository.findById(id).orElse(null), AccountDTO.class);
    }

    @Override
    public Account create(AccountForm accountForm) {


        if (accountRepository.existsAccountByUserName(accountForm.getUserName())){
            throw new BusinessException("đã tồn tại username"+accountForm.getUserName(),500);
        }
        if (accountRepository.existsAccountByEmail(accountForm.getEmail())){
            throw new BusinessException("đã tồn tại Email"+accountForm.getEmail(),500);
        }
        Department dep=departmentRepository.findDepartmentByDepartmentName(accountForm.getDepartmentName());
        if (Objects.isNull(dep)){
            throw new BusinessException("không tồn tại tồn tại department"+accountForm.getDepartmentName(),500);
        }
        Position pos=positionRepository.findById(accountForm.getPositionId()).orElse(null);
        if (Objects.isNull(pos)){
            throw new BusinessException("không tồn tại tồn tại position"+accountForm.getPositionId(),500);
        }
        Account account=new  Account();
        account.setUserName(accountForm.getUserName());
        account.setFullName(accountForm.getFullName());
        account.setEmail(accountForm.getEmail());
        account.setDepartment(dep);
        account.setPosition(pos);
        account.setPassword(accountForm.getPassword());
        account.setCreateDate(LocalDate.now());

        return accountRepository.save(account);
    }

    @Override
    public Account update(Integer id, AccountForm accountFormUpdate) {
        Account account = accountRepository.findById(id).orElse(null);
        if(account==null){
            throw new BusinessException("không tồn tại account id "+id,500);
        }
        else {


            if (accountRepository.existsAccountByUserNameAndAccountIdNot(accountFormUpdate.getUserName(),id)){
                throw new BusinessException("đã tồn tại username"+accountFormUpdate.getUserName(),500);
            }
            if (accountRepository.existsAccountByEmailAndAccountIdNot(accountFormUpdate.getEmail(),id)){
                throw new BusinessException("đã tồn tại Email"+accountFormUpdate.getEmail(),500);
            }
            Department dep=departmentRepository.findDepartmentByDepartmentName(accountFormUpdate.getDepartmentName());
            if (Objects.isNull(dep)){
                throw new BusinessException("không tồn tại tồn tại department"+accountFormUpdate.getDepartmentName(),500);
            }
            Position pos=positionRepository.findById(accountFormUpdate.getPositionId()).orElse(null);
            if (Objects.isNull(pos)){
                throw new BusinessException("không tồn tại tồn tại position"+accountFormUpdate.getPositionId(),500);
            }
            account.setUserName(accountFormUpdate.getUserName());
            account.setFullName(accountFormUpdate.getFullName());
            account.setEmail(accountFormUpdate.getEmail());
            account.setDepartment(dep);
            account.setPosition(pos);
            account.setPassword(accountFormUpdate.getPassword());
            return accountRepository.save(account);
        }
    }

    @Override
    public void deleteById(Integer id) {
        Account account1 = accountRepository.findById(id).orElse(null);
        if(account1==null){
            throw new BusinessException("không tồn tại account id "+id,500);
        }
        else {
            accountRepository.deleteById(id);
        }
    }
}
