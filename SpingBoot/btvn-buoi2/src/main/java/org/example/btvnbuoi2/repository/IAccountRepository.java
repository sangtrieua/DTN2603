package org.example.btvnbuoi2.repository;

import org.example.btvnbuoi2.dto.AccountDTO;
import org.example.btvnbuoi2.embeddable.GroupAccountId;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.GroupAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface IAccountRepository extends JpaRepository<Account, Integer> ,JpaSpecificationExecutor<Account>{
    boolean existsAccountByUserName(String userName);

    boolean existsAccountByEmail(String email);

    boolean existsAccountByUserNameAndAccountIdNot(String userName, Integer id);

    boolean existsAccountByEmailAndAccountIdNot(String email, Integer id);

    Account findAccountByUserName(String accountCreatorUserName);
}
