package com.company.customerservice.dto.request;

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

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("patronymic")
    private String patronymic;
    @JsonProperty("birthDate")
    private long birthDate;
    @JsonProperty("finCode")
    private String finCode;
    @JsonProperty("docSerial")
    private String docSerial;
    @JsonProperty("docNumber")
    private Integer docNumber;
    @JsonProperty("martialStatus")
    private String martialStatus;
    @JsonProperty("expireDate")
    private long expireDate;
    @JsonProperty("givenDate")
    private long givenDate;
    @JsonProperty("registrationAddress")
    private String registrationAddress;
}
