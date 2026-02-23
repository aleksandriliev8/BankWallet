package com.bank.wallet.wallet_backend.controller;

import com.bank.wallet.wallet_backend.dto.request.DepositRequestDTO;
import com.bank.wallet.wallet_backend.dto.request.TransferRequest;
import com.bank.wallet.wallet_backend.dto.request.WithdrawRequestDTO;
import com.bank.wallet.wallet_backend.dto.response.WalletResponseDTO;
import com.bank.wallet.wallet_backend.service.WalletService;
import jakarta.validation.Valid;
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
    public ResponseEntity<WalletResponseDTO> deposit(@Valid @RequestBody DepositRequestDTO request) {
        WalletResponseDTO response = walletService.deposit(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<WalletResponseDTO> withdraw(@Valid @RequestBody WithdrawRequestDTO request) {
        WalletResponseDTO response = walletService.withdraw(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/transfer")
    public ResponseEntity<WalletResponseDTO> transfer(@Valid @RequestBody TransferRequest request) {
        WalletResponseDTO response = walletService.transfer(request);
        return ResponseEntity.ok(response);
    }
}