package com.bank.wallet.wallet_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @GetMapping("/secret")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getAdminTest() {
        return ResponseEntity.ok("Admin has now access");
    }
}
