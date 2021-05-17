package com.company.customerservice.entity;

import com.company.customerservice.enums.ContractStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "customer",name = "customers")
public class CustomerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private Integer status;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "customer_personal_id",referencedColumnName = "id",
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "customer_personal_fk"))
    private PersonalInfo personalInfo;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "customer_employee_id",referencedColumnName = "id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "customer_employee_fk"))
    private EmployeeInfo employeeInfo;

}
