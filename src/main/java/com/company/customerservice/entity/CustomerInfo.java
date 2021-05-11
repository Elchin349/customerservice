package com.company.customerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerInfo {

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
    @Column(name = "contract_number")
    private String contractNumber;
    @Column(name = "contract_begin_date")
    private LocalDateTime beginDate;
    @Column(name = "contract_end_date")
    private LocalDateTime endDate;
    @Column(name = "contract_status")
    private String contractStatus;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "security_number")
    private String securityNumber;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "customer_personal_id",referencedColumnName = "id",
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "customer_personal_fk"))
    private PersonalInfo personalInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_address_id",referencedColumnName = "id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "customer_address_fk"))
    private AddressContactInfo addressContactInfo;

    @PrePersist
    private void createDateNow(){
        this.createdDate = LocalDateTime.now();
        this.uniqueId = UUID.randomUUID();
    }








}
