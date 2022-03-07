package com.muto.preG.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
