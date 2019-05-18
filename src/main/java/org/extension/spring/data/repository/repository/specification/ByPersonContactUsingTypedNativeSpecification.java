package org.extension.spring.data.repository.repository.specification;

import org.extension.spring.data.repository.model.PersonContactResultMapping;
import org.extension.spring.data.repository.specification.TypedNativeQuerySpecification;

import javax.persistence.Query;

public class ByPersonContactUsingTypedNativeSpecification
        implements TypedNativeQuerySpecification<PersonContactResultMapping> {

    @Override
    public String query() {
        return " SELECT " +
                " p.email, p.name, c.name as contact" +
                " FROM Person p " +
                " INNER JOIN Contact c ON p.email = c.person_email";
    }

}
