package com.company.customerservice.mappers;

import com.company.customerservice.dto.request.CustomerInfoRequestDto;
import com.company.customerservice.dto.request.EmployeeInfoRequestDto;
import com.company.customerservice.dto.request.PersonalInfoRequestDto;
import com.company.customerservice.entity.CustomerInfo;
import com.company.customerservice.entity.EmployeeInfo;
import com.company.customerservice.entity.PersonalInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomerUpdateMapper {

    private final DateMapper dateMapper;

    public CustomerInfo toUpdateCustomer(CustomerInfoRequestDto customerInfoRequestDto, CustomerInfo customerInfoDb) {
        if(customerInfoRequestDto.getEmployee() != null){
            customerInfoDb.setEmployeeInfo(toUpdateEmployee(customerInfoRequestDto.getEmployee(),customerInfoDb.getEmployeeInfo()));
        }
        if(customerInfoRequestDto.getPersonal() != null){
            customerInfoDb.setPersonalInfo(toUpdatePersonal(customerInfoRequestDto.getPersonal(),customerInfoDb.getPersonalInfo()));
        }

        return customerInfoDb;
    }

    private EmployeeInfo toUpdateEmployee(EmployeeInfoRequestDto employeeInfoRequestDto, EmployeeInfo employeeInfo) {
        if (employeeInfoRequestDto.getWorkPlace() != null) employeeInfo.setWorkPlace(employeeInfoRequestDto.getWorkPlace());
        if (employeeInfoRequestDto.getPosition() != null) employeeInfo.setPosition(employeeInfoRequestDto.getPosition());
        if (employeeInfoRequestDto.getSalary() != null) employeeInfo.setSalary(employeeInfoRequestDto.getSalary());
        if (employeeInfoRequestDto.getWorkPhone() != null) employeeInfo.setWorkPhone(employeeInfoRequestDto.getWorkPhone());
        if (employeeInfoRequestDto.getPhone() != null) employeeInfo.setPhone(employeeInfoRequestDto.getPhone());
        if (employeeInfoRequestDto.getCurrentAddress() != null) employeeInfo.setCurrentAddress(employeeInfoRequestDto.getCurrentAddress());
        return employeeInfo;
    }


    private PersonalInfo toUpdatePersonal(PersonalInfoRequestDto personalInfoRequestDto, PersonalInfo personalInfoDb) {

        if (personalInfoRequestDto.getFirstName() != null)
            personalInfoDb.setFirstName(personalInfoRequestDto.getFirstName());
        if (personalInfoRequestDto.getLastName() != null)
            personalInfoDb.setLastName(personalInfoRequestDto.getLastName());
        if (personalInfoRequestDto.getPatronymic() != null)
            personalInfoDb.setPatronymic(personalInfoRequestDto.getPatronymic());
        if (personalInfoRequestDto.getBirthDate() != null)
            personalInfoDb.setBirthDate(dateMapper.millisToLocalDate(personalInfoRequestDto.getBirthDate()));
        if (personalInfoRequestDto.getFinCode() != null)
            personalInfoDb.setFinCode(personalInfoRequestDto.getFinCode());
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


}
