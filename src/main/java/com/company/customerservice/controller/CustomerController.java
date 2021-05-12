package com.company.customerservice.controller;

import com.company.customerservice.dto.request.CustomerInfoRequestDto;
import com.company.customerservice.dto.response.CustomerInfoDetailResponseDto;
import com.company.customerservice.dto.response.CustomerInfoResponseDto;
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
    public ResponseEntity<CustomerInfoDetailResponseDto> save(@RequestBody CustomerInfoRequestDto customerInfoRequestDto) {
        return new ResponseEntity<>(customerInfoService.saveCustomer(customerInfoRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerInfoDetailResponseDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(customerInfoService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<List<CustomerInfoDetailResponseDto>> findAllDetail(@RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                                                             @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                                             @RequestParam(name = "status", required = false) Integer contractStatus,
                                                                             @RequestParam(name = "minSalary", required = false, defaultValue = "250") Double minSalary,
                                                                             @RequestParam(name = "maxSalary", required = false, defaultValue = "30000") Double maxSalary
    ) {
        return new ResponseEntity<>(customerInfoService.findAllDetail(pageNumber, pageSize, contractStatus, minSalary, maxSalary), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<CustomerInfoResponseDto>> findAll(@RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                                                 @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return new ResponseEntity<>(customerInfoService.findAllOnlyCustomerInfo(pageNumber, pageSize), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerInfoDetailResponseDto> update(@PathVariable Long id, @RequestBody CustomerInfoRequestDto customerInfoRequestDto) {
        return new ResponseEntity<>(customerInfoService.update(id, customerInfoRequestDto), HttpStatus.OK);
    }

}
