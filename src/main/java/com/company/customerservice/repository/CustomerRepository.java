package com.company.customerservice.repository;

import com.company.customerservice.entity.CustomerInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerInfo,Long> {
//
//    Page<CustomerInfo> findAllBySalaryGreaterThanEqualAndSalaryLessThanEqual(Pageable pageable,Double minSalary,Double maxSalary);
      Page<CustomerInfo> findAllByEmployeeInfoSalaryGreaterThanEqualAndEmployeeInfoSalaryLessThanEqual(Pageable pageable,Double minSalary,Double maxSalary);
//
//    Page<CustomerInfo>findAllByContractStatusAndSalaryGreaterThanEqualAndSalaryLessThanEqual(Integer status,Pageable pageable,Double minSalary,Double maxSalary);
}
