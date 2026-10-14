package org.example.btvnbuoi2.service.impl;

import org.example.btvnbuoi2.config.ModelMapperConfig;
import org.example.btvnbuoi2.dto.AccountDTO;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.Department;
import org.example.btvnbuoi2.entity.GroupAccount;
import org.example.btvnbuoi2.entity.Position;
import org.example.btvnbuoi2.enums.PositionName;
import org.example.btvnbuoi2.form.AccountForm;
import org.example.btvnbuoi2.repository.IAccountRepository;
import org.example.btvnbuoi2.repository.IDepartmentRepository;
import org.example.btvnbuoi2.repository.IGroupAccountRepository;
import org.example.btvnbuoi2.repository.IPositionRepository;
import org.example.btvnbuoi2.service.IAccountService;
import org.example.btvnbuoi2.service.IGroupAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<AccountDTO> findAll() {
        List<Account> accounts=  accountRepository.findAll();
        List<AccountDTO> dtos=new ArrayList<>();
        for(Account account:accounts){
            AccountDTO dto= modelMapper.map(account,AccountDTO.class);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public AccountDTO findById(Integer id) {
        return modelMapper.map(accountRepository.findById(id).orElse(null), AccountDTO.class);
    }

    @Override
    public Account create(AccountForm accountForm) {
        accountForm.checkNull();

        if (accountRepository.existsAccountByUserName(accountForm.getUserName())){
            throw new RuntimeException("đã tồn tại username"+accountForm.getUserName());
        }
        if (accountRepository.existsAccountByEmail(accountForm.getEmail())){
            throw new RuntimeException("đã tồn tại Email"+accountForm.getEmail());
        }
        Department dep=departmentRepository.findDepartmentByDepartmentName(accountForm.getDepartmentName());
        if (Objects.isNull(dep)){
            throw new RuntimeException("không tồn tại tồn tại department"+accountForm.getDepartmentName());
        }
        Position pos=positionRepository.findById(accountForm.getPositionId()).orElse(null);
        if (Objects.isNull(pos)){
            throw new RuntimeException("không tồn tại tồn tại position"+accountForm.getPositionId());
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
            throw new RuntimeException("không tồn tại account id "+id);
        }
        else {
            accountFormUpdate.checkNull();

            if (accountRepository.existsAccountByUserNameAndAccountIdNot(accountFormUpdate.getUserName(),id)){
                throw new RuntimeException("đã tồn tại username"+accountFormUpdate.getUserName());
            }
            if (accountRepository.existsAccountByEmailAndAccountIdNot(accountFormUpdate.getEmail(),id)){
                throw new RuntimeException("đã tồn tại Email"+accountFormUpdate.getEmail());
            }
            Department dep=departmentRepository.findDepartmentByDepartmentName(accountFormUpdate.getDepartmentName());
            if (Objects.isNull(dep)){
                throw new RuntimeException("không tồn tại tồn tại department"+accountFormUpdate.getDepartmentName());
            }
            Position pos=positionRepository.findById(accountFormUpdate.getPositionId()).orElse(null);
            if (Objects.isNull(pos)){
                throw new RuntimeException("không tồn tại tồn tại position"+accountFormUpdate.getPositionId());
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
            throw new RuntimeException("không tồn tại account id "+id);
        }
        else {
            accountRepository.deleteById(id);
        }
    }
}
