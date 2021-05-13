package com.company.customerservice.service;

import com.company.customerservice.dto.request.CustomerInfoRequestDto;
import com.company.customerservice.dto.response.CustomerInfoDetailResponseDto;
import com.company.customerservice.dto.response.CustomerInfoResponseDto;
import com.company.customerservice.dto.response.CustomerPageList;

import java.util.List;

public interface CustomerInfoService {

    CustomerInfoDetailResponseDto findById(Long id);

    CustomerPageList findAllDetail(Integer pageNumber, Integer pageSize, Integer status, Double minSalary, Double maxSalary);

    CustomerInfoDetailResponseDto saveCustomer(CustomerInfoRequestDto requestDto);

    List<CustomerInfoResponseDto> findAllOnlyCustomerInfo(Integer pageNumber,Integer pageSize );

    CustomerInfoDetailResponseDto update(Long id, CustomerInfoRequestDto requestDto);
}

