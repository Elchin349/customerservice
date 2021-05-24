package com.company.customerservice.service;

import com.company.customerservice.dto.request.CustomerInfoRequestDto;
import com.company.customerservice.dto.response.CustomerInfoResponseDto;
import com.company.customerservice.dto.response.CustomerPageList;

import java.util.List;

public interface CustomerInfoService {

    CustomerInfoResponseDto findById(Long id);

    CustomerPageList findAllDetail(Integer pageNumber, Integer pageSize);

    CustomerInfoResponseDto saveCustomer(CustomerInfoRequestDto requestDto);

    CustomerPageList search(Integer pageNumber, Integer pageSize, Integer status, String firstName, String lastName, String finCode, String martialStatus, String birthPlace, String workPlace, String position);

    CustomerInfoResponseDto update(Long id, CustomerInfoRequestDto requestDto);
}

