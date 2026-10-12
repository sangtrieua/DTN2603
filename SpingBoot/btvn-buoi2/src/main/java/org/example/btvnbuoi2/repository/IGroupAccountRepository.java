package org.example.btvnbuoi2.repository;

import org.example.btvnbuoi2.embeddable.GroupAccountId;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.Group;
import org.example.btvnbuoi2.entity.GroupAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGroupAccountRepository extends JpaRepository<GroupAccount, GroupAccountId> {
    void deleteGroupAccountByGroup(Group group1);

    List<GroupAccount> findAllByAccount(Account account);

    List<GroupAccount> findAllByGroup(Group group);
}
