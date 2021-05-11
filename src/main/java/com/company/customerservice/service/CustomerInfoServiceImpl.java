package com.company.customerservice.service;

import com.company.customerservice.dto.request.CustomerInfoRequestDto;
import com.company.customerservice.dto.response.CustomerInfoDetailResponseDto;
import com.company.customerservice.mappers.CustomerMapper;
import com.company.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerInfoServiceImpl implements CustomerInfoService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerInfoDetailResponseDto findById(Long id) {
        return customerMapper.toResponseDto(customerRepository.findById(id).get());
    }

    @Override
    public List<CustomerInfoDetailResponseDto> findAllDetail() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerInfoDetailResponseDto saveCustomer(CustomerInfoRequestDto requestDto) {
        return customerMapper.toResponseDto(customerRepository.save(customerMapper.toCustomerInfo(requestDto)));
    }
}
