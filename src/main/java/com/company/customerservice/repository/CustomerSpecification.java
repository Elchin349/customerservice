package com.company.customerservice.repository;

import com.company.customerservice.entity.CustomerInfo;
import com.company.customerservice.entity.EmployeeInfo;
import com.company.customerservice.entity.PersonalInfo;
import org.springframework.data.jpa.domain.Specification;


import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerSpecification implements Specification<CustomerInfo> {

    private static final long serialVersionUID = -8120153501796231474L;

    private List<SearchCriteria> criteriaList;

    public CustomerSpecification() {
        this.criteriaList = new ArrayList<>();
    }

    public void add(SearchCriteria criteria) {
        criteriaList.add(criteria);
    }


    public void add(Integer status, String firstName, String lastName, String finCode, String martialStatus, String birthPlace, String workPlace, String position) {
        if (status != null) add(new SearchCriteria("status", status, SearchOperation.EQUAL));
        if (firstName != null)
            add(new SearchCriteria("firstName", firstName, SearchOperation.JOIN_PERSONAL, SearchOperation.EQUAL));
        if (lastName != null)
            add(new SearchCriteria("lastName", lastName, SearchOperation.JOIN_PERSONAL, SearchOperation.EQUAL));
        if (finCode != null)
            add(new SearchCriteria("finCode", finCode, SearchOperation.JOIN_PERSONAL, SearchOperation.EQUAL));
        if (martialStatus != null)
            add(new SearchCriteria("martialStatus", martialStatus, SearchOperation.JOIN_PERSONAL, SearchOperation.EQUAL));
        if (birthPlace != null)
            add(new SearchCriteria("birthPlace", birthPlace, SearchOperation.JOIN_PERSONAL, SearchOperation.EQUAL));
        if (workPlace != null)
            add(new SearchCriteria("workPlace", workPlace, SearchOperation.JOIN_EMPLOYEE, SearchOperation.EQUAL));
        if (position != null)
            add(new SearchCriteria("position", position, SearchOperation.JOIN_EMPLOYEE, SearchOperation.EQUAL));
    }

    @Override
    public Predicate toPredicate(Root<CustomerInfo> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();

        for (SearchCriteria criteria : criteriaList) {
            if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
                predicates.add(builder.equal(
                        root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        "%" + criteria.getValue().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_END)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        criteria.getValue().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_START)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        "%" + criteria.getValue().toString().toLowerCase()));
            } else if (criteria.getOperation().equals(SearchOperation.IN)) {
                predicates.add(builder.in(root.get(criteria.getKey())).value(criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.NOT_IN)) {
                predicates.add(builder.not(root.get(criteria.getKey())).in(criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.JOIN_PERSONAL)) {
                Join<CustomerInfo, PersonalInfo> customerInfoPersonalInfoJoin = root.join("personalInfo", JoinType.INNER);
                if (criteria.getSubOperation().equals(SearchOperation.EQUAL)) {
                    predicates.add(
                            builder.equal(customerInfoPersonalInfoJoin.get(criteria.getKey()).as(String.class), criteria.getValue())
                    );
                } else if (criteria.getSubOperation().equals(SearchOperation.BETWEEN_DATE)) {
                    predicates.add(
                            builder.between(root.get(criteria.getKey()), (LocalDate) criteria.getValue(), (LocalDate) criteria.getValue2())
                    );
                }
            } else if (criteria.getOperation().equals(SearchOperation.JOIN_EMPLOYEE)) {
                Join<CustomerInfo, EmployeeInfo> customerInfoPersonalInfoJoin = root.join("employeeInfo", JoinType.INNER);
                if (criteria.getSubOperation().equals(SearchOperation.EQUAL)) {
                    predicates.add(
                            builder.equal(customerInfoPersonalInfoJoin.get(criteria.getKey()).as(String.class), criteria.getValue())
                    );
                } else if (criteria.getSubOperation().equals(SearchOperation.BETWEEN_SALARY)) {
                    predicates.add(
                            builder.between(root.get(criteria.getKey()), (Double) criteria.getValue(), (Double) criteria.getValue2()));
                }

            }
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
