package com.bank.wallet.wallet_backend.service;

import com.bank.wallet.wallet_backend.dto.request.UserRegistrationRequestDTO;
import com.bank.wallet.wallet_backend.dto.response.UserResponseDTO;
import com.bank.wallet.wallet_backend.dto.response.WalletResponseDTO;
import com.bank.wallet.wallet_backend.mapper.UserMapper;
import com.bank.wallet.wallet_backend.model.User;
import com.bank.wallet.wallet_backend.model.Wallet;
import com.bank.wallet.wallet_backend.repository.UserRepository;
import com.bank.wallet.wallet_backend.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserResponseDTO registerUser(UserRegistrationRequestDTO userDto) {
        if (userRepository.existsByUsername(userDto.username())) {
            throw new IllegalArgumentException("Username is already taken");
        }

        if (userRepository.existsByEmail(userDto.email())) {
            throw new IllegalArgumentException("Email is already registered");
        }

        User user = userMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);

        Wallet wallet = new Wallet();
        wallet.setBalance(0.0);
        savedUser.addWallet(wallet);
        Wallet savedWallet = walletRepository.save(wallet);

        WalletResponseDTO walletDto = new WalletResponseDTO(savedWallet.getId(), savedWallet.getBalance());
        return userMapper.toResponse(savedUser, walletDto);
    }
}
