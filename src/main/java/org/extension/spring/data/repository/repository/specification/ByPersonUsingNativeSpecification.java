package org.extension.spring.data.repository.repository.specification;

import spring.data.repository.specification.NativeQuerySpecification;

import javax.persistence.Query;

public class ByPersonUsingNativeSpecification implements NativeQuerySpecification {

    @Override
    public String query() {
        return "SELECT * FROM Person p";
    }

    @Override
    public void toPredicate(final Query query) {
    }

}
