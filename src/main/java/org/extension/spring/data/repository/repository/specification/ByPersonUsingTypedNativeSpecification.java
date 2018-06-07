package org.extension.spring.data.repository.repository.specification;

import org.extension.spring.data.repository.model.Person;
import spring.data.repository.specification.TypedNativeQuerySpecification;

import javax.persistence.Query;

public class ByPersonUsingTypedNativeSpecification
        implements TypedNativeQuerySpecification<Person> {

    @Override
    public String query() {
        return " SELECT " +
                " * " +
                "FROM Person p";
    }


    @Override
    public void toPredicate(final Query query) {
    }

}
