package org.first.first.repositories;

import java.util.Optional;

import org.first.first.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

    // @SuppressWarnings({ "null", "unchecked" })
    // Account save(Account account);

    Optional<Account> findOneByEmailIgnoreCase(String email);
    
}