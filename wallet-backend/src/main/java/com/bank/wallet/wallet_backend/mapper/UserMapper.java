package com.bank.wallet.wallet_backend.mapper;

import com.bank.wallet.wallet_backend.dto.request.UserRegistrationRequestDTO;
import com.bank.wallet.wallet_backend.dto.response.UserResponseDTO;
import com.bank.wallet.wallet_backend.dto.response.WalletResponseDTO;
import com.bank.wallet.wallet_backend.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "wallet", source = "walletDto")
    UserResponseDTO toResponse(User user, WalletResponseDTO walletDto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "firstName", source = "dto.firstName")
    @Mapping(target = "lastName", source = "dto.lastName")
    @Mapping(target = "username", source = "dto.username")
    @Mapping(target = "email", source = "dto.email")
    @Mapping(target = "password", source = "dto.password")
    @Mapping(target = "age", source = "dto.age")
    User toEntity(UserRegistrationRequestDTO dto);
}