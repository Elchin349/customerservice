package com.company.customerservice.service;

import com.company.customerservice.dto.request.CustomerInfoRequestDto;
import com.company.customerservice.dto.response.CustomerInfoResponseDto;
import com.company.customerservice.dto.response.CustomerPageList;

import java.util.List;

public interface CustomerInfoService {

    CustomerInfoResponseDto findById(Long id);

    CustomerPageList findAllDetail(Integer pageNumber, Integer pageSize, Integer status, Double minSalary, Double maxSalary);

    CustomerInfoResponseDto saveCustomer(CustomerInfoRequestDto requestDto);


    CustomerInfoResponseDto update(Long id, CustomerInfoRequestDto requestDto);
}

