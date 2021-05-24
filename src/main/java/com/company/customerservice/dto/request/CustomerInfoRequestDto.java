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
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("employee")
    private EmployeeInfoRequestDto employeeInfo;
    @JsonProperty("personal")
    private PersonalInfoRequestDto personalInfo;

}
