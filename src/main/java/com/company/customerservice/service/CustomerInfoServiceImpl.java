package com.company.customerservice.service;

import com.company.customerservice.dto.request.CustomerInfoRequestDto;
import com.company.customerservice.dto.response.CustomerInfoDetailResponseDto;
import com.company.customerservice.dto.response.CustomerInfoResponseDto;
import com.company.customerservice.mappers.CustomerMapper;
import com.company.customerservice.mappers.DateMapper;
import com.company.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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
        return customerMapper.toResponseDetailDto(customerRepository.findById(id).get());
    }

    @Override
    public List<CustomerInfoDetailResponseDto> findAllDetail(Integer pageNumber, Integer pageSize, Integer status, Double salary) {
        if (status != null && salary != null) {
            return findAllByStatusAndSalary(status, salary, pageNumber, pageSize);
        }
        else if(status != null){
            return findAllByContractStatus(pageNumber, pageSize, status);
        }
        else if (salary != null){
            return findAllBySalary(salary, pageNumber, pageSize);
        }
        return findAll(pageNumber, pageSize);
    }

    @Override
    public CustomerInfoDetailResponseDto saveCustomer(CustomerInfoRequestDto requestDto) {
        return customerMapper.toResponseDetailDto(customerRepository.save(customerMapper.toCustomerInfo(requestDto)));
    }

    private List<CustomerInfoDetailResponseDto> findAllByContractStatus(Integer pageNumber, Integer pageSize, Integer status) {
        return customerRepository.findAllByContractStatus(status, PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(customerMapper::toResponseDetailDto)
                .collect(Collectors.toList());

    }

    private List<CustomerInfoDetailResponseDto> findAll(Integer pageNumber, Integer pageSize) {
        return customerRepository.findAll(PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(customerMapper::toResponseDetailDto)
                .collect(Collectors.toList());

    }

    private List<CustomerInfoDetailResponseDto> findAllBySalary(Double salary,Integer pageNumber, Integer pageSize) {
        return customerRepository.findAllBySalary(salary,PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(customerMapper::toResponseDetailDto)
                .collect(Collectors.toList());

    }

    private List<CustomerInfoDetailResponseDto> findAllByStatusAndSalary(Integer status,Double salary,Integer pageNumber, Integer pageSize) {
        return customerRepository.findAllByContractStatusAndSalary(status,salary,PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(customerMapper::toResponseDetailDto)
                .collect(Collectors.toList());

    }

}
