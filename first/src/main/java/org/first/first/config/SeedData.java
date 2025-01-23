package org.first.first.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.first.first.models.Account;
import org.first.first.models.Authority;
import org.first.first.models.Post;
import org.first.first.services.PostService;
import org.first.first.util.constants.Privillages;
import org.first.first.util.constants.Roles;
import org.first.first.services.AccountService;
import org.first.first.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedData implements CommandLineRunner{
    @Autowired
        private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public void run(String... args) throws Exception {

        for(Privillages auth: Privillages.values()){
            Authority authority = new Authority();
            authority.setId(auth.getId());
            authority.setName(auth.getPrivillage());
            authorityService.save(authority);
        }

        Account account01 = new Account();
        Account account02 = new Account();
        Account account03 = new Account();
        Account account04 = new Account();

        account01.setEmail("ac01@org");
        account01.setPassword("password");
        account01.setFirstname("user1");
        account01.setLastname("lastname01");

        account02.setEmail("ac02@org");
        account02.setPassword("password");
        account02.setFirstname("user2");
        account02.setLastname("lastname02");
        account02.setRole(Roles.ADMIN.getRole());

        account03.setEmail("ac03@org");
        account03.setPassword("password");
        account03.setFirstname("user3");
        account03.setLastname("lastname03");
        account03.setRole(Roles.EDITOR.getRole());

        account04.setEmail("ac04@org");
        account04.setPassword("password");
        account04.setFirstname("user4");
        account04.setLastname("lastname04");
        account04.setRole(Roles.EDITOR.getRole());

        Set<Authority> authorities = new HashSet<>();
        authorityService.findById(Privillages.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authorities::add);
        authorityService.findById(Privillages.ACCESS_ADMIN_PANEL.getId()).ifPresent(authorities::add);
        account04.setAuthorities(authorities);


        accountService.save(account01);
        accountService.save(account02);
        accountService.save(account03);
        accountService.save(account04);

        List<Post> posts = postService.getAll();
        if(posts.size()==0){
            Post post01 = new Post();
            post01.setTitle("post 01");;
            post01.setBody("Post 01 body...........");
            post01.setAccount(account01);
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("post 02");;
            post02.setBody("Post 02 body...........");
            post02.setAccount(account02);
            postService.save(post02);
        }
        // throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
    
}
