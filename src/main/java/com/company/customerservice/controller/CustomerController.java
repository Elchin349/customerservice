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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * http://localhost:9090/swagger-ui.html#/  for swagger use this url
 */
@CrossSafeRestResource(path = "/api")
@RequiredArgsConstructor
public class CustomerController implements ApiBuilder {

    private final CustomerInfoService customerInfoService;

    @PostMapping(value = "/save")
    public ResponseEntity<SingleMessage<CustomerInfoResponseDto>> save(@RequestBody CustomerInfoRequestDto customerInfoRequestDto) {
        return ResponseEntity.ok(generateSingleMessage(customerInfoService.saveCustomer(customerInfoRequestDto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SingleMessage<CustomerInfoResponseDto>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(generateSingleMessage(customerInfoService.findById(id)));
    }

    @GetMapping("/detail")
    public ResponseEntity<SingleMessage<CustomerPageList>> findAllDetail(
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize
    ) {
        return ResponseEntity.ok(generateSingleMessage(customerInfoService.findAllDetail(pageNumber, pageSize)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SingleMessage<CustomerInfoResponseDto>> update(@PathVariable Long id, @RequestBody CustomerInfoRequestDto customerInfoRequestDto) {
        return ResponseEntity.ok(generateSingleMessage(customerInfoService.update(id, customerInfoRequestDto)));
    }

    @GetMapping("/search")
    public ResponseEntity<SingleMessage<CustomerPageList>> search(@RequestParam (name = "page",required = false ,defaultValue = "0")Integer page,
                                                                  @RequestParam(name = "size",required = false,defaultValue = "20")Integer size,
                                                                  @RequestParam(required = false) Integer status,
                                                                  @RequestParam(required = false) String firstName,
                                                                  @RequestParam(required = false) String lastName,
                                                                  @RequestParam(required = false) String finCode,
                                                                  @RequestParam(required = false) String martialStatus,
                                                                  @RequestParam(required = false) String birthPlace,
                                                                  @RequestParam(required = false) String workPlace,
                                                                  @RequestParam(required = false) String position){

        return ResponseEntity.ok(generateSingleMessage(customerInfoService.search(page, size, status, firstName, lastName, finCode, martialStatus, birthPlace, workPlace, position)));
    }

}
