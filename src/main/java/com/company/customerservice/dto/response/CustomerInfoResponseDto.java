package com.company.customerservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerInfoResponseDto implements Serializable {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("employee")
    private EmployeeInfoResponseDto employee;
    @JsonProperty("personal")
    private PersonalInfoResponseDto personal;
}
