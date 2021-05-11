package com.company.customerservice.dto.response;

import com.company.customerservice.dto.request.AddressContactInfoRequestDto;
import com.company.customerservice.dto.request.PersonalInfoRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerInfoResponseDto {

    private Long id;
    @JsonProperty("uniqueId")
    private UUID uniqueId;
    @JsonProperty("workPlace")
    private String workPlace;
    @JsonProperty("position")
    private String position;
    @JsonProperty("salary")
    private Double salary;
    @JsonProperty("contractNumber")
    private String contractNumber;
    @JsonProperty("beginDate")
    private long beginDate;
    @JsonProperty("endDate")
    private long endDate;
    @JsonProperty("contractStatus")
    private String contractStatus;
    @JsonProperty("securityNumber")
    private String securityNumber;
    @JsonProperty("createdDate")
    private long createdDate;
}
