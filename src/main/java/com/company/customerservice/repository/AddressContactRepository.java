package com.company.customerservice.repository;

import com.company.customerservice.entity.AddressContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressContactRepository extends JpaRepository<AddressContactInfo,Long> {
}
