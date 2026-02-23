package com.bank.wallet.wallet_backend.service;

import com.bank.wallet.wallet_backend.dto.request.DepositRequestDTO;
import com.bank.wallet.wallet_backend.dto.request.TransferRequest;
import com.bank.wallet.wallet_backend.dto.request.WithdrawRequestDTO;
import com.bank.wallet.wallet_backend.dto.response.WalletResponseDTO;
import com.bank.wallet.wallet_backend.model.Wallet;
import com.bank.wallet.wallet_backend.repository.UserRepository;
import com.bank.wallet.wallet_backend.repository.WalletRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;

    @Transactional
    public WalletResponseDTO deposit(DepositRequestDTO depositDto) {
        Wallet wallet = walletRepository.findByUserId(depositDto.userId())
                .orElseThrow(() -> new EntityNotFoundException("Wallet not found"));

        wallet.setBalance(wallet.getBalance() + depositDto.amount());
        Wallet savedWallet = walletRepository.save(wallet);

        return new WalletResponseDTO(savedWallet.getId(), savedWallet.getBalance());
    }

    @Transactional
    public WalletResponseDTO withdraw(WithdrawRequestDTO withdrawDto) {

        Wallet wallet = walletRepository.findByUserId(withdrawDto.userId())
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        if (wallet.getBalance() < withdrawDto.amount()) {
            throw new RuntimeException("Insufficient funds. Current balance: " + wallet.getBalance());
        }

        wallet.setBalance(wallet.getBalance() - withdrawDto.amount());
        Wallet updatedWallet = walletRepository.save(wallet);

        return new WalletResponseDTO(updatedWallet.getId(), updatedWallet.getBalance());
    }

    @Transactional
    public WalletResponseDTO transfer(TransferRequest transferDto) {
        if (transferDto.amount() <= 0) {
            throw new RuntimeException("Transfer amount must be positive");
        }

        if (transferDto.fromUserId().equals(transferDto.toUserId())) {
            throw new RuntimeException("Cannot transfer money to yourself");
        }

        Wallet sourceWallet = walletRepository.findByUserId(transferDto.fromUserId())
                .orElseThrow(() -> new RuntimeException("Source wallet not found"));

        Wallet targetWallet = walletRepository.findByUserId(transferDto.toUserId())
                .orElseThrow(() -> new RuntimeException("Target wallet not found"));

        if (sourceWallet.getBalance() < transferDto.amount()) {
            throw new RuntimeException("Insufficient funds for transfer");
        }

        sourceWallet.setBalance(sourceWallet.getBalance() - transferDto.amount());
        targetWallet.setBalance(targetWallet.getBalance() + transferDto.amount());

        walletRepository.save(sourceWallet);
        walletRepository.save(targetWallet);

        return new WalletResponseDTO(sourceWallet.getId(), sourceWallet.getBalance());
    }
}
