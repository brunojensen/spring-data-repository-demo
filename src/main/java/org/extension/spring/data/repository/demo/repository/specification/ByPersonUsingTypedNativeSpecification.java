package org.extension.spring.data.repository.demo.repository.specification;

import org.extension.spring.data.repository.specification.TypedNativeQuerySpecification;

public class ByPersonUsingTypedNativeSpecification
  implements TypedNativeQuerySpecification {

  @Override
  public String query() {
    return " SELECT p.* FROM Person p";
  }


}
