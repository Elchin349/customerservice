package com.company.customerservice.mappers;

import com.company.customerservice.dto.request.CustomerInfoRequestDto;
import com.company.customerservice.dto.response.CustomerInfoResponseDto;
import com.company.customerservice.entity.CustomerInfo;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = DateMapper.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper {

    CustomerInfo toCustomerInfo(CustomerInfoRequestDto requestDto);

    CustomerInfoResponseDto toResponse(CustomerInfo customerInfo);


}
