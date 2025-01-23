package org.first.first.services;

import java.util.Optional;

import org.first.first.models.Authority;
import org.first.first.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {
    
    @Autowired
    private AuthorityRepository authorityRepository;

    public Authority save(Authority authority){
        return authorityRepository.save(authority);
    }
    public Optional<Authority> findById(Long id){
        return authorityRepository.findById(id);
    }
}
