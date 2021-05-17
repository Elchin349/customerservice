package com.company.customerservice.controller;

import com.company.customerservice.container.CrossSafeRestResource;
import com.company.customerservice.container.api.ApiBuilder;
import com.company.customerservice.container.api.CollectionMessage;
import com.company.customerservice.container.api.SingleMessage;
import com.company.customerservice.dto.request.CustomerInfoRequestDto;
import com.company.customerservice.dto.response.CustomerInfoResponseDto;
import com.company.customerservice.dto.response.CustomerPageList;
import com.company.customerservice.service.CustomerInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * http://localhost:9090/swagger-ui.html#/  for swagger use this url
 */
@CrossSafeRestResource(path = "/api")
@RequiredArgsConstructor
public class CustomerController implements ApiBuilder {

    private final CustomerInfoService customerInfoService;

    @PostMapping
    public ResponseEntity<SingleMessage<CustomerInfoResponseDto>> save(@RequestBody CustomerInfoRequestDto customerInfoRequestDto) {
        return ResponseEntity.ok(generateSingleMessage(customerInfoService.saveCustomer(customerInfoRequestDto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SingleMessage<CustomerInfoResponseDto>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(generateSingleMessage(customerInfoService.findById(id)));
    }

    @GetMapping("/detail")
    public ResponseEntity<SingleMessage<CustomerPageList>> findAllDetail(@RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                                          @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                          @RequestParam(name = "status", required = false) Integer contractStatus,
                                                          @RequestParam(name = "minSalary", required = false, defaultValue = "250") Double minSalary,
                                                          @RequestParam(name = "maxSalary", required = false, defaultValue = "30000") Double maxSalary
    ) {
        return ResponseEntity.ok(generateSingleMessage(customerInfoService.findAllDetail(pageNumber, pageSize, contractStatus, minSalary, maxSalary)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SingleMessage<CustomerInfoResponseDto>> update(@PathVariable Long id, @RequestBody CustomerInfoRequestDto customerInfoRequestDto) {
        return  ResponseEntity.ok(generateSingleMessage(customerInfoService.update(id, customerInfoRequestDto)));
    }

}
