package com.bea.spring.boot.repository;

import com.bea.spring.boot.model.Person;
import com.bea.spring.repository.RepositorySpecificationExecutor;

public interface PersonRepository extends RepositorySpecificationExecutor<Person, String> {
}
