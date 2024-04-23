package com.example.aoms.api.service;

import com.example.aoms.api.entity.Address;
import com.example.aoms.api.dto.CompanyDto;
import com.example.aoms.api.entity.Company;
import com.example.aoms.api.mapper.CompanyMapper;
import com.example.aoms.api.repository.CompanyRepository;
import com.example.aoms.api.jwt_token.service.JwtService;
import com.example.aoms.api.entity.user.User;
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
    private final JwtService jwtService;

    @Override
    //FIXME Think if @SneakyThrows annotation is needed here
    @SneakyThrows
    @Transactional
    public Company save(CompanyDto dto, User user) {
        Address address = addressService.save(dto.getAddress());
        Company entity = CompanyMapper.mapDtoToEntity(dto, address, user);
        return companyRepository.save(entity);
    }

    @Override
    public Optional<Company> findCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Optional<CompanyDto> findCompanyDtoByJwt(String jwt) {
        Long userId = jwtService.extractUserId(jwt);
        return companyRepository.findByUserId(userId)
                .map(CompanyMapper::mapEntityToDto);
    }

    @Override
    public Optional<Company> findCompanyByJwt(String jwt) {
        Long userId = jwtService.extractUserId(jwt);
        return companyRepository.findByUserId(userId);
    }
}
