package org.example.btvnbuoi2.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.example.btvnbuoi2.entity.Account;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.domain.Specification;
@AllArgsConstructor
public class AccountCustomSepcification implements Specification<Account> {
    private String field;
    private Object value;
    @Override
    public @Nullable Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if("userName".equalsIgnoreCase(field)){
            return criteriaBuilder.like(root.get("userName"), "%"+value+"%");
        }
        if("email".equalsIgnoreCase(field)){
            return criteriaBuilder.like(root.get("email"), "%"+value+"%");
        }
        if("fullName".equalsIgnoreCase(field)){
            return criteriaBuilder.like(root.get("fullName"), "%"+value+"%");
        }
        if("depName".equalsIgnoreCase(field)){
            return criteriaBuilder.like(root.get("department").get("departmentName"), "%"+value+"%");
        }
        if("posName".equalsIgnoreCase(field)){
            return criteriaBuilder.like(root.get("position").get("positionName"), "%"+value+"%");
        }


        return null;
    }
}
