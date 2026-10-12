package org.example.btvnbuoi2.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.btvnbuoi2.embeddable.GroupAccountId;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.Group;
import org.example.btvnbuoi2.entity.GroupAccount;
import org.example.btvnbuoi2.repository.IAccountRepository;
import org.example.btvnbuoi2.repository.IGroupAccountRepository;
import org.example.btvnbuoi2.repository.IGroupRepository;
import org.example.btvnbuoi2.service.IGroupAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GroupAccountServiceImpl implements IGroupAccountService {
    @Autowired
    private IGroupAccountRepository  groupAccountRepository;
    @Autowired
    private IGroupRepository  groupRepository;
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public List<GroupAccount> findAll() {
        return groupAccountRepository.findAll();
    }

    @Override
    public void deleteByGroup(Group group1) {
        groupAccountRepository.deleteGroupAccountByGroup(group1);
    }

    @Override
    public GroupAccount addAccountToGroup(Integer idGroup, Integer accountId) {
        Group group = groupRepository.findById(idGroup)
                .orElseThrow(()->new EntityNotFoundException("Group not found"));
        Account account1=accountRepository.findById(accountId)
                .orElseThrow(()->new EntityNotFoundException("Account not found"));
        GroupAccount groupAccount = new GroupAccount();
        groupAccount.setGroup(group);
        groupAccount.setAccount(account1);
        groupAccount.setId(new GroupAccountId(group.getId(),account1.getAccountId()));
        groupAccount.setJoinDate(new Date());
        return groupAccountRepository.save(groupAccount);

    }

    @Override
    public List<GroupAccount> findAllByAccountId(Integer accountId) {
        Account account=accountRepository.findById(accountId)
                .orElseThrow(()->new EntityNotFoundException("Account not found"));
        return groupAccountRepository.findAllByAccount(account);
    }

    @Override
    public List<GroupAccount> findAllByGroupId(Integer groupId) {
        Group group=groupRepository.findById(groupId)
                .orElseThrow(()->new EntityNotFoundException("Group not found"));
        return groupAccountRepository.findAllByGroup(group);
    }
}
