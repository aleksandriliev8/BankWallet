package com.bank.wallet.wallet_backend.repository;

import com.bank.wallet.wallet_backend.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WalletRepository  extends JpaRepository<Wallet, UUID> {
}
