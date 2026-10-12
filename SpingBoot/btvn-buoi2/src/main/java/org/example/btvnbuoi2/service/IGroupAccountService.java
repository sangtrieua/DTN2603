package org.example.btvnbuoi2.service;

import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.Group;
import org.example.btvnbuoi2.entity.GroupAccount;

import java.util.List;

public interface IGroupAccountService {
    List<GroupAccount> findAll();

    void deleteByGroup(Group group1);

    GroupAccount addAccountToGroup(Integer idGroup, Integer accountId);

    List<GroupAccount> findAllByAccountId(Integer accountId);

    List<GroupAccount> findAllByGroupId(Integer groupId);
}
