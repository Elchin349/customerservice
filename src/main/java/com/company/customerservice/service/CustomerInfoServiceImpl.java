package com.company.customerservice.service;

import com.company.customerservice.dto.request.CustomerInfoRequestDto;
import com.company.customerservice.dto.response.CustomerInfoResponseDto;
import com.company.customerservice.dto.response.CustomerPageList;
import com.company.customerservice.entity.CustomerInfo;
import com.company.customerservice.enums.BusinessStatus;
import com.company.customerservice.exceptions.NotFoundException;
import com.company.customerservice.mappers.CustomerMapper;
import com.company.customerservice.mappers.CustomerUpdateMapper;
import com.company.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public CustomerInfoResponseDto findById(Long id) {
        Optional<CustomerInfo> customerInfo = customerRepository.findById(id);
        if (customerInfo.isPresent())
            return customerMapper.toResponse(customerInfo.get());
        throw new NotFoundException(BusinessStatus.CUSTOMER_INFO_BY_ID_NOT_FOUND);
    }

    @Override
    public CustomerPageList findAllDetail(Integer pageNumber, Integer pageSize, Integer status, Double minSalary, Double maxSalary) {
        CustomerPageList customerPageList = null;
//        Page<CustomerInfo> customerInfoPage;
//        if (status != null) {
//            customerInfoPage = customerRepository.findAllByContractStatusAndSalaryGreaterThanEqualAndSalaryLessThanEqual(status, PageRequest.of(pageNumber, pageSize), minSalary, maxSalary);
//        } else {
//            customerInfoPage = customerRepository.findAllBySalaryGreaterThanEqualAndSalaryLessThanEqual(PageRequest.of(pageNumber, pageSize), minSalary, maxSalary);
//        }
//        customerPageList = new CustomerPageList(customerInfoPage.getContent()
//                .stream()
//                .map(customerMapper::toResponse)
//                .collect(Collectors.toList()),
//                customerInfoPage.getTotalPages(),
//                customerInfoPage.getTotalElements());
        return customerPageList;
    }

    @Override
    public CustomerInfoResponseDto saveCustomer(CustomerInfoRequestDto requestDto) {
        return customerMapper.toResponse(customerRepository.save(customerMapper.toCustomerInfo(requestDto)));
    }


    @Override
    public CustomerInfoResponseDto update(Long id, CustomerInfoRequestDto requestDto) {
        Optional<CustomerInfo> customerInfo = customerRepository.findById(id);
        if (customerInfo.isPresent()) {
            CustomerInfo customerInfoDb = customerUpdateMapper.toUpdateCustomer(requestDto, customerInfo.get());
            customerRepository.save(customerInfoDb);
            return customerMapper.toResponse(customerInfoDb);
        }
        throw new NotFoundException(BusinessStatus.CUSTOMER_INFO_BY_ID_NOT_FOUND);
    }

}
