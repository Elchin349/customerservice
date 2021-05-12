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
public class PersonalInfoRequestDto {

    @JsonIgnore
    private Long id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("patronymic")
    private String patronymic;
    @JsonProperty("birthDate")
    private Long birthDate;
    @JsonProperty("finCode")
    private String finCode;
    @JsonProperty("docSerial")
    private String docSerial;
    @JsonProperty("docNumber")
    private Integer docNumber;
    @JsonProperty("martialStatus")
    private String martialStatus;
    @JsonProperty("expireDate")
    private Long expireDate;
    @JsonProperty("givenDate")
    private Long givenDate;
    @JsonProperty("registrationAddress")
    private String registrationAddress;
}
