package com.bank.wallet.wallet_backend.service;

import com.bank.wallet.wallet_backend.dto.request.DepositRequestDTO;
import com.bank.wallet.wallet_backend.dto.request.WithdrawRequestDTO;
import com.bank.wallet.wallet_backend.dto.response.WalletResponseDTO;
import com.bank.wallet.wallet_backend.model.Wallet;
import com.bank.wallet.wallet_backend.repository.UserRepository;
import com.bank.wallet.wallet_backend.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;
    private final UserRepository userRepository;

    @Transactional
    public WalletResponseDTO deposit(DepositRequestDTO depositDto) {
        Wallet wallet = walletRepository.findByUserId(depositDto.userId())
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        wallet.setBalance(wallet.getBalance() + depositDto.amount());
        Wallet savedWallet = walletRepository.save(wallet);

        return new WalletResponseDTO(savedWallet.getId(), savedWallet.getBalance());
    }

    @Transactional
    public WalletResponseDTO withdraw(WithdrawRequestDTO withdrawData) {

        if (!userRepository.existsById(withdrawData.userId())) {
            throw new RuntimeException("User not found with ID: " + withdrawData.userId());
        }

        Wallet wallet = walletRepository.findByUserId(withdrawData.userId())
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        if (wallet.getBalance() < withdrawData.amount()) {
            throw new RuntimeException("Insufficient funds. Current balance: " + wallet.getBalance());
        }

        wallet.setBalance(wallet.getBalance() - withdrawData.amount());
        Wallet updatedWallet = walletRepository.save(wallet);

        return new WalletResponseDTO(updatedWallet.getId(), updatedWallet.getBalance());
    }
}
