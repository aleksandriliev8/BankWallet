package com.bank.wallet.wallet_backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Column(unique = true, nullable = false)
    private String username;

    private int age;

    @OneToOne(mappedBy = "user")
    @JsonManagedReference
    private Wallet wallet;

    public void addWallet(Wallet wallet) {
        this.wallet = wallet;
        wallet.setUser(this);
    }
}
