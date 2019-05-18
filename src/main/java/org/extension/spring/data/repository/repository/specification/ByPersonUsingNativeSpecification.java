package org.extension.spring.data.repository.repository.specification;

import org.extension.spring.data.repository.specification.NativeQuerySpecification;

public class ByPersonUsingNativeSpecification implements NativeQuerySpecification {

    @Override
    public String query() {
        return "SELECT * FROM Person p";
    }


}
