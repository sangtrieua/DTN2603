package org.example.btvnbuoi2.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.btvnbuoi2.dto.GroupAccountDTO;
import org.example.btvnbuoi2.embeddable.GroupAccountId;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.Group;
import org.example.btvnbuoi2.entity.GroupAccount;
import org.example.btvnbuoi2.form.GroupAccountForm;
import org.example.btvnbuoi2.repository.IAccountRepository;
import org.example.btvnbuoi2.repository.IGroupAccountRepository;
import org.example.btvnbuoi2.repository.IGroupRepository;
import org.example.btvnbuoi2.service.IGroupAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupAccountServiceImpl implements IGroupAccountService {
    @Autowired
    private IGroupAccountRepository  groupAccountRepository;
    @Autowired
    private IGroupRepository  groupRepository;
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<GroupAccountDTO> findAll() {
        List<GroupAccount> groupAccounts=groupAccountRepository.findAll();
        List<GroupAccountDTO> dtos=new ArrayList<>();
        for(GroupAccount groupAccount:groupAccounts){
            GroupAccountDTO dto=modelMapper.map(groupAccount,GroupAccountDTO.class);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public void deleteByGroup(Group group1) {
        groupAccountRepository.deleteGroupAccountByGroup(group1);
    }

    @Override
    public GroupAccount addAccountToGroup(GroupAccountForm groupAccountForm) {
        groupAccountForm.checkNull();
        Group group = groupRepository.findGroupByName(groupAccountForm.getGroupName());
        if(Objects.isNull(group)){
            throw new RuntimeException("Không tồn tại group "+groupAccountForm.getGroupName());
        }
        Account account1=accountRepository.findAccountByUserName(groupAccountForm.getAccountUserName());
        if(Objects.isNull(account1)){
            throw new RuntimeException("Không tồn tại account "+groupAccountForm.getAccountUserName());
        }
        GroupAccountId gid=new GroupAccountId(group.getId(),account1.getAccountId());
        if (groupAccountRepository.existsById(gid)){
            throw new RuntimeException("đã có account "+groupAccountForm.getAccountUserName()+" trong group "+ group.getName());
        }
        GroupAccount groupAccount = new GroupAccount();
        groupAccount.setGroup(group);
        groupAccount.setAccount(account1);
        groupAccount.setId(gid);
        groupAccount.setJoinDate(new Date());
        return groupAccountRepository.save(groupAccount);

    }

    @Override
    public List<GroupAccountDTO> findAllByAccountId(Integer accountId) {
        Account account=accountRepository.findById(accountId)
                .orElseThrow(()->new EntityNotFoundException("Account not found"));
        List<GroupAccount> groupAccounts=groupAccountRepository.findAllByAccount(account);
        List<GroupAccountDTO> dtos=new ArrayList<>();
        for(GroupAccount groupAccount:groupAccounts){
            GroupAccountDTO dto=modelMapper.map(groupAccount,GroupAccountDTO.class);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public List<GroupAccountDTO> findAllByGroupId(Integer groupId) {
        Group group=groupRepository.findById(groupId)
                .orElseThrow(()->new EntityNotFoundException("Group not found"));
        List<GroupAccount> groupAccounts=groupAccountRepository.findAllByGroup(group);
        List<GroupAccountDTO> dtos=new ArrayList<>();
        for(GroupAccount groupAccount:groupAccounts){
            GroupAccountDTO dto=modelMapper.map(groupAccount,GroupAccountDTO.class);
            dtos.add(dto);
        }
        return dtos;
    }
}
