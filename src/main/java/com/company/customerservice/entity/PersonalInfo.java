package com.company.customerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "customer",name = "personal_info")
public class PersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "fin_code")
    private String finCode;
    @Column(name = "doc_serial")
    private String docSerial;
    @Column(name = "doc_number")
    private Integer docNumber;
    @Column(name = "martial_status")
    private String martialStatus;
    @Column(name = "expire_date")
    private LocalDate expireDate;
    @Column(name = "given_date")
    private LocalDate givenDate;
    @Column(name = "birth_place")
    private String birthPlace;
    @Column(name = "registration_address")
    private String registrationAddress;

}
