package com.company.customerservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeInfoResponseDto {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("uniqueId")
    private UUID uniqueId;
    @JsonProperty("workPlace")
    private String workPlace;
    @JsonProperty("position")
    private String position;
    @JsonProperty("salary")
    private Double salary;
    @JsonProperty("createdDate")
    private LocalDateTime createdDate;
    @JsonProperty("updatedDate")
    private LocalDateTime updatedDate;
    @JsonProperty("workPlace")
    private String workPhone;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("currentAddress")
    private String currentAddress;
}
