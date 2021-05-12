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
public class AddressContactInfoRequestDto {

    @JsonIgnore
    private Long id;
    @JsonProperty("currentAddress")
    private String currentAddress;
    @JsonProperty("phone1")
    private String phone1;
    @JsonProperty("phone2")
    private String phone2;
    @JsonProperty("country")
    private String country;
    @JsonProperty("city")
    private String city;
    @JsonProperty("district")
    private String district;
    @JsonProperty("street")
    private String street;
    @JsonProperty("email")
    private String email;
}
