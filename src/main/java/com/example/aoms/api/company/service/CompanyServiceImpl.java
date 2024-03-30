package com.example.aoms.api.company.service;

import com.example.aoms.api.address.entity.Address;
import com.example.aoms.api.address.service.AddressService;
import com.example.aoms.api.company.dto.CompanyDto;
import com.example.aoms.api.company.entity.Company;
import com.example.aoms.api.company.mapper.CompanyMapper;
import com.example.aoms.api.company.repository.CompanyRepository;
import com.example.aoms.api.jwt_token.service.JwtService;
import com.example.aoms.api.user.entity.User;
import com.example.aoms.api.user.exception.UserNotFoundException;
import com.example.aoms.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final AddressService addressService;
    private final UserService userService;
    private final JwtService jwtService;

    @Override
    @SneakyThrows
    @Transactional
    public Company save(CompanyDto dto, String jwt) {
        Address address = addressService.save(dto.getAddress());
        User user = findUserFromJwt(jwt);
        Company entity = CompanyMapper.mapDtoToEntity(dto, address, user);
        return companyRepository.save(entity);
    }

    @Override
    public Optional<Company> findCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Optional<CompanyDto> findCompanyByUserEmailFromJwt(String jwt) {
        User user = findUserFromJwt(jwt);
        return companyRepository.findByUser(user)
                .map(CompanyMapper::mapEntityToDto);
    }

    private User findUserFromJwt(String jwt) {
        String email = jwtService.extractEmail(jwt);
        return userService.findUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with email %s not found", email)));
    }
}
