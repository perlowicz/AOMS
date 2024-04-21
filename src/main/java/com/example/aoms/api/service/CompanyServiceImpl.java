package com.example.aoms.api.service;

import com.example.aoms.api.entity.Address;
import com.example.aoms.api.dto.CompanyDto;
import com.example.aoms.api.entity.Company;
import com.example.aoms.api.mapper.CompanyMapper;
import com.example.aoms.api.repository.CompanyRepository;
import com.example.aoms.api.jwt_token.service.JwtService;
import com.example.aoms.api.entity.user.User;
import com.example.aoms.api.exception.UserNotFoundException;
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
    public Optional<CompanyDto> findCompanyByJwt(String jwt) {
        Long userId = jwtService.extractUserId(jwt);
        return companyRepository.findByUserId(userId)
                .map(CompanyMapper::mapEntityToDto);
    }

    private User findUserFromJwt(String jwt) {
        Long userId = jwtService.extractUserId(jwt);
        return userService.findUserById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id %s not found", userId)));
    }
}
