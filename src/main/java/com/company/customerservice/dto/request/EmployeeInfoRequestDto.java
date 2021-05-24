package com.company.customerservice.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeInfoRequestDto {

    @JsonIgnore
    private Long id;

    @JsonProperty("workPlace")
    private String workPlace;

    @JsonProperty("position")
    private String position;

    @JsonProperty("salary")
    private Double salary;

    @JsonProperty("workPhone")
    private String workPhone;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("currentAddress")
    private String currentAddress;
}
