package com.company.customerservice.mappers;

import com.company.customerservice.dto.request.AddressContactInfoRequestDto;
import com.company.customerservice.dto.request.CustomerInfoRequestDto;
import com.company.customerservice.dto.request.PersonalInfoRequestDto;
import com.company.customerservice.entity.AddressContactInfo;
import com.company.customerservice.entity.CustomerInfo;
import com.company.customerservice.entity.PersonalInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomerUpdateMapper {

    private final DateMapper dateMapper;

    public CustomerInfo toUpdateCustomer(CustomerInfoRequestDto customerInfoRequestDto,CustomerInfo customerInfoDb) {

        if (customerInfoRequestDto.getWorkPlace() != null)
            customerInfoDb.setWorkPlace(customerInfoRequestDto.getWorkPlace());
        if (customerInfoRequestDto.getPosition() != null)
            customerInfoDb.setPosition(customerInfoRequestDto.getPosition());
        if (customerInfoRequestDto.getSalary() != null) customerInfoDb.setSalary(customerInfoRequestDto.getSalary());
        if (customerInfoRequestDto.getContractNumber() != null)
            customerInfoDb.setContractNumber(customerInfoRequestDto.getContractNumber());
        if (customerInfoRequestDto.getBeginDate() != null)
            customerInfoDb.setBeginDate(dateMapper.millisToLocalDateTime(customerInfoRequestDto.getBeginDate()));
        if (customerInfoRequestDto.getEndDate() != null)
            customerInfoDb.setEndDate(dateMapper.millisToLocalDateTime(customerInfoRequestDto.getEndDate()));
        if (customerInfoRequestDto.getContractStatus() != null)
            customerInfoDb.setContractStatus(customerInfoRequestDto.getContractStatus());
        if (customerInfoRequestDto.getPersonalInfo() != null) {
            customerInfoDb.setPersonalInfo(toUpdatePersonal(customerInfoRequestDto.getPersonalInfo(),customerInfoDb.getPersonalInfo()));
        }
        if (customerInfoRequestDto.getAddressContactInfo() != null) {
            customerInfoDb.setAddressContactInfo(toUpdateAddressContactInfo(customerInfoRequestDto.getAddressContactInfo(),customerInfoDb.getAddressContactInfo()));
        }

        return customerInfoDb;
    }

    private PersonalInfo toUpdatePersonal(PersonalInfoRequestDto personalInfoRequestDto,PersonalInfo personalInfoDb) {

        if (personalInfoRequestDto.getFirstName() != null)
            personalInfoDb.setFirstName(personalInfoRequestDto.getFirstName());
        if (personalInfoRequestDto.getLastName() != null)
            personalInfoDb.setLastName(personalInfoRequestDto.getLastName());
        if (personalInfoRequestDto.getPatronymic() != null)
            personalInfoDb.setPatronymic(personalInfoRequestDto.getPatronymic());
        if (personalInfoRequestDto.getBirthDate() != null)
            personalInfoDb.setBirthDate(dateMapper.millisToLocalDate(personalInfoRequestDto.getBirthDate()));
        if (personalInfoRequestDto.getFinCode() != null) personalInfoDb.setFinCode(personalInfoRequestDto.getFinCode());
        if (personalInfoRequestDto.getDocNumber() != null)
            personalInfoDb.setDocNumber(personalInfoRequestDto.getDocNumber());
        if (personalInfoRequestDto.getDocSerial() != null)
            personalInfoDb.setDocSerial(personalInfoRequestDto.getDocSerial());
        if (personalInfoRequestDto.getMartialStatus() != null)
            personalInfoDb.setMartialStatus(personalInfoRequestDto.getMartialStatus());
        if (personalInfoRequestDto.getExpireDate() != null)
            personalInfoDb.setExpireDate(dateMapper.millisToLocalDate(personalInfoRequestDto.getExpireDate()));
        if (personalInfoRequestDto.getGivenDate() != null)
            personalInfoDb.setGivenDate(dateMapper.millisToLocalDate(personalInfoRequestDto.getGivenDate()));
        if (personalInfoRequestDto.getRegistrationAddress() != null)
            personalInfoDb.setRegistrationAddress(personalInfoRequestDto.getRegistrationAddress());

        return personalInfoDb;
    }

    private AddressContactInfo toUpdateAddressContactInfo(AddressContactInfoRequestDto requestDto,AddressContactInfo contactInfoDb) {
        if (requestDto.getCurrentAddress() != null) contactInfoDb.setCurrentAddress(requestDto.getCurrentAddress());
        if (requestDto.getPhone1() != null) contactInfoDb.setPhone1(requestDto.getPhone1());
        if (requestDto.getPhone2() != null) contactInfoDb.setPhone2(requestDto.getPhone2());
        if (requestDto.getCountry() != null) contactInfoDb.setCountry(requestDto.getCountry());
        if (requestDto.getCity() != null) contactInfoDb.setCity(requestDto.getCity());
        if (requestDto.getDistrict() != null) contactInfoDb.setDistrict(requestDto.getDistrict());
        if (requestDto.getStreet() != null) contactInfoDb.setStreet(requestDto.getStreet());
        if (requestDto.getEmail() != null) contactInfoDb.setEmail(requestDto.getEmail());

        return contactInfoDb;
    }


}
