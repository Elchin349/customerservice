package com.company.customerservice.entity;

import com.company.customerservice.enums.ContractStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "customer",name = "employee_info")
public class EmployeeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unique_id")
    private UUID uniqueId;
    @Column(name = "work_place")
    private String workPlace;
    @Column(name = "postion")
    private String position;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "work_phone")
    private String workPhone;
    @Column(name = "phone")
    private String phone;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    @Column(name = "current_address")
    private String currentAddress;

    @OneToOne(mappedBy = "employeeInfo",orphanRemoval = true)
    private PersonalInfo personalInfo;

    @PrePersist
    private void createDateNow(){
        this.createdDate = LocalDateTime.now();
        this.uniqueId = UUID.randomUUID();
    }

    @PostUpdate
    private void updateDate(){
        this.updatedDate = LocalDateTime.now();
    }
}
