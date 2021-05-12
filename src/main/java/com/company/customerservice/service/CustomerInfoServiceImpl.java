package com.company.customerservice.service;

import com.company.customerservice.dto.request.CustomerInfoRequestDto;
import com.company.customerservice.dto.response.CustomerInfoDetailResponseDto;
import com.company.customerservice.dto.response.CustomerInfoResponseDto;
import com.company.customerservice.entity.CustomerInfo;
import com.company.customerservice.mappers.CustomerMapper;
import com.company.customerservice.mappers.CustomerUpdateMapper;
import com.company.customerservice.mappers.DateMapper;
import com.company.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerInfoServiceImpl implements CustomerInfoService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final CustomerUpdateMapper customerUpdateMapper;


    @Override
    public CustomerInfoDetailResponseDto findById(Long id) {
        return customerMapper.toResponseDetailDto(customerRepository.findById(id).get());
    }

    @Override
    public List<CustomerInfoDetailResponseDto> findAllDetail(Integer pageNumber, Integer pageSize, Integer status, Double minSalary, Double maxSalary) {
        if (status != null) {
            findAllByContractStatus(pageNumber, pageSize, status);
        }
        return findAll(pageNumber, pageSize, minSalary, maxSalary);
    }

    @Override
    public CustomerInfoDetailResponseDto saveCustomer(CustomerInfoRequestDto requestDto) {
        return customerMapper.toResponseDetailDto(customerRepository.save(customerMapper.toCustomerInfo(requestDto)));
    }

    @Override
    public List<CustomerInfoResponseDto> findAllOnlyCustomerInfo(Integer pageNumber, Integer pageSize) {
        return customerRepository.findAll(PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(customerMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerInfoDetailResponseDto update(Long id, CustomerInfoRequestDto requestDto) {
        Optional<CustomerInfo> customerInfo = customerRepository.findById(id);
        if(customerInfo.isPresent()){
            CustomerInfo customerInfoDb = customerUpdateMapper.toUpdateCustomer(requestDto,customerInfo.get());
            customerRepository.save(customerInfoDb);
            return customerMapper.toResponseDetailDto(customerInfoDb);
        }
        return null; // exeption atilacaq
    }

    private List<CustomerInfoDetailResponseDto> findAllByContractStatus(Integer pageNumber, Integer pageSize, Integer status) {
        return customerRepository.findAllByContractStatus(status, PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(customerMapper::toResponseDetailDto)
                .collect(Collectors.toList());

    }

    private List<CustomerInfoDetailResponseDto> findAll(Integer pageNumber, Integer pageSize, Double minSalary, Double maxSalary) {
        return customerRepository.findAllBySalaryGreaterThanEqualAndSalaryLessThanEqual(PageRequest.of(pageNumber, pageSize), minSalary, maxSalary)
                .stream()
                .map(customerMapper::toResponseDetailDto)
                .collect(Collectors.toList());

    }

}
