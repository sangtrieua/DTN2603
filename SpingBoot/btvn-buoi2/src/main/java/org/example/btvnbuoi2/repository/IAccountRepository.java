package org.example.btvnbuoi2.repository;

import org.example.btvnbuoi2.embeddable.GroupAccountId;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.GroupAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    boolean existsAccountByUserName(String userName);

    boolean existsAccountByEmail(String email);

    boolean existsAccountByUserNameAndAccountIdNot(String userName, Integer id);

    boolean existsAccountByEmailAndAccountIdNot(String email, Integer id);

    Account findAccountByUserName(String accountCreatorUserName);
}
