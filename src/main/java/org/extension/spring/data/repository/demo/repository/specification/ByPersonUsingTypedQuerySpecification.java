package org.extension.spring.data.repository.demo.repository.specification;

import org.extension.spring.data.repository.demo.model.Person;
import org.extension.spring.data.repository.specification.TypedQuerySpecification;

import javax.persistence.Query;
import java.util.Objects;
import java.util.Optional;

public class ByPersonUsingTypedQuerySpecification implements TypedQuerySpecification {

  private final Person person;

  public ByPersonUsingTypedQuerySpecification(Person person) {
    this.person = person;
  }

  @Override
  public boolean isSatisfied() {
    return Optional.ofNullable(person)
      .filter(p -> Objects.nonNull(p.getName()))
      .isPresent();
  }

  @Override
  public String query() {
    return "SELECT p FROM Person p WHERE p.name like :name";
  }

  @Override
  public void withPredicate(final Query query) {
    query.setParameter("name", person.getName());
  }

}
