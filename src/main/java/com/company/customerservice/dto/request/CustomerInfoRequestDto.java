package com.company.customerservice.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerInfoRequestDto {

    @JsonIgnore
    private Long id;
    @JsonProperty("workPlace")
    private String workPlace;
    @JsonProperty("position")
    private String position;
    @JsonProperty("salary")
    private Double salary;
    @JsonProperty("contractNumber")
    private String contractNumber;
    @JsonProperty("beginDate")
    private Long beginDate;
    @JsonProperty("endDate")
    private Long endDate;
    @JsonProperty("contractStatus")
    private Integer contractStatus;
    @JsonProperty("securityNumber")
    private String securityNumber;

    @JsonProperty("personalInfo")
    private PersonalInfoRequestDto personalInfo;
    @JsonProperty("addressContactInfo")
    private AddressContactInfoRequestDto addressContactInfo;
}
