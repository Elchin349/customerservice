package com.company.customerservice.controller;

import com.company.customerservice.dto.request.CustomerInfoRequestDto;
import com.company.customerservice.dto.response.CustomerInfoDetailResponseDto;
import com.company.customerservice.service.CustomerInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerInfoService customerInfoService;

    @PostMapping
    public ResponseEntity<CustomerInfoDetailResponseDto> save(@RequestBody CustomerInfoRequestDto customerInfoRequestDto){
        return new ResponseEntity<>(customerInfoService.saveCustomer(customerInfoRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerInfoDetailResponseDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(customerInfoService.findById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerInfoDetailResponseDto>> findAllDetail(){
        return new ResponseEntity<>(customerInfoService.findAllDetail(),HttpStatus.OK);
    }
}
