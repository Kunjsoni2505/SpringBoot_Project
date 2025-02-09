package org.first.first.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Email(message = "Invalid Email...")
    @NotEmpty(message = "Email is Missing")
    private String email;

    @NotEmpty(message = "password is Missing")
    private String password;

    @NotEmpty(message = "Firstname is Missing")
    private String firstname;

    @NotEmpty(message = "Lastname is Missing")
    private String lastname;

    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_of_birth;

    private String photo;

    private String role;

    @OneToMany(mappedBy = "account")
    private List<Post> posts;

    @Column(name="token")
    private String password_reset_token;

    private LocalDateTime password_reset_token_expiry;

    @ManyToMany
    @JoinTable(
        name="account_authority",
        joinColumns = {@JoinColumn(name="account_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
        private Set<Authority> authorities = new HashSet<>();


        public void setToken(String token) {
        this.password_reset_token = token;
    }
}
