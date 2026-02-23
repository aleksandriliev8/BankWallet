package com.bank.wallet.wallet_backend.controller;

import com.bank.wallet.wallet_backend.dto.request.DepositRequestDTO;
import com.bank.wallet.wallet_backend.dto.request.TransferRequest;
import com.bank.wallet.wallet_backend.dto.request.WithdrawRequestDTO;
import com.bank.wallet.wallet_backend.dto.response.WalletResponseDTO;
import com.bank.wallet.wallet_backend.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wallets")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @PostMapping("/deposit")
    public WalletResponseDTO deposit(@RequestBody DepositRequestDTO request) {
        return walletService.deposit(request);
    }

    @PostMapping("/withdraw")
    public WalletResponseDTO withdraw(@RequestBody WithdrawRequestDTO request) {
        return walletService.withdraw(request);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferRequest request) {
        walletService.transfer(request);
        return ResponseEntity.ok("Transfer successful");
    }
}