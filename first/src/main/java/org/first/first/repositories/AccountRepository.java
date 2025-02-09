package org.first.first.repositories;

import java.util.Optional;

import org.first.first.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

    // @SuppressWarnings({ "null", "unchecked" })
    // Account save(Account account);

    Optional<Account> findOneByEmailIgnoreCase(String email);

    @Query("SELECT a FROM Account a WHERE a.password_reset_token = :token")
    Optional<Account> findByToken(@Param("token") String token);
    
}