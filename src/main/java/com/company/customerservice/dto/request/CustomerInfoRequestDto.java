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
    @JsonProperty("employee")
    private EmployeeInfoRequestDto employee;
    @JsonProperty("personal")
    private PersonalInfoRequestDto personal;

}
