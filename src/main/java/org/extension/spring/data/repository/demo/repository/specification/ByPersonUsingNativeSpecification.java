package org.extension.spring.data.repository.demo.repository.specification;

import org.extension.spring.data.repository.specification.NativeQuerySpecification;

public class ByPersonUsingNativeSpecification implements NativeQuerySpecification {

  @Override
  public String query() {
    return "SELECT p.* FROM Person p";
  }


}
