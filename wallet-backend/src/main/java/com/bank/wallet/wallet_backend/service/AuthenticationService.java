package com.bank.wallet.wallet_backend.service;

import com.bank.wallet.wallet_backend.dto.request.AuthRequestDTO;
import com.bank.wallet.wallet_backend.dto.response.AuthResponseDTO;
import com.bank.wallet.wallet_backend.repository.UserRepository;
import com.bank.wallet.wallet_backend.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponseDTO authenticate(AuthRequestDTO request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        var user = userRepository.findByUsername(request.username())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return new AuthResponseDTO(jwtToken);
    }
}
