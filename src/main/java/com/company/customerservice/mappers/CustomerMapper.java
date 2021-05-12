package com.company.customerservice.mappers;

import com.company.customerservice.dto.request.CustomerInfoRequestDto;
import com.company.customerservice.dto.response.CustomerInfoDetailResponseDto;
import com.company.customerservice.dto.response.CustomerInfoResponseDto;
import com.company.customerservice.entity.CustomerInfo;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface CustomerMapper {

    CustomerInfo toCustomerInfo(CustomerInfoRequestDto requestDto);

    CustomerInfoDetailResponseDto toResponseDetailDto(CustomerInfo customerInfo);

    CustomerInfoResponseDto toResponse(CustomerInfo customerInfo);

}
