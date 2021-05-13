package com.company.customerservice.dto.response;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class CustomerPageList extends PageImpl<CustomerInfoDetailResponseDto> implements Serializable {
    static final long serialVersionUID = -6295995986844729471L;
    private final int totalPages;
    private final long totalElements;

    public CustomerPageList(List<CustomerInfoDetailResponseDto> content, int totalPages, long totalElements) {
        super(content);
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    @Override
    public long getTotalElements() {
        return totalElements;
    }

    @Override
    public int getTotalPages() {
        return totalPages;
    }
}
