package org.example.btvnbuoi2.service;

import org.example.btvnbuoi2.dto.GroupAccountDTO;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.Group;
import org.example.btvnbuoi2.entity.GroupAccount;
import org.example.btvnbuoi2.form.GroupAccountForm;

import java.util.List;

public interface IGroupAccountService {
    List<GroupAccountDTO> findAll();

    void deleteByGroup(Group group1);

    GroupAccount addAccountToGroup(GroupAccountForm groupAccountForm);

    List<GroupAccountDTO> findAllByAccountId(Integer accountId);

    List<GroupAccountDTO> findAllByGroupId(Integer groupId);
}
