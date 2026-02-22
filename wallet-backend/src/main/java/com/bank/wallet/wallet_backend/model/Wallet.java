package com.bank.wallet.wallet_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Double balance = 0.0;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

}