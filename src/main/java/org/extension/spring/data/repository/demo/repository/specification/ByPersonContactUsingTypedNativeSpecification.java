package org.extension.spring.data.repository.demo.repository.specification;

import org.extension.spring.data.repository.specification.TypedNativeQuerySpecification;

public class ByPersonContactUsingTypedNativeSpecification
  implements TypedNativeQuerySpecification {

  @Override
  public String query() {
    return """
       SELECT p.email, p.name, c.name as contact
       FROM Person p
       INNER JOIN Contact c ON p.email = c.person_email
       """;
  }

}
