package org.extension.spring.data.repository.demo.repository;

import org.extension.spring.data.repository.RepositorySpecificationExecutor;
import org.extension.spring.data.repository.demo.model.Person;
import org.extension.spring.data.repository.demo.model.PersonRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import static org.extension.spring.data.repository.demo.model.PersonRecord.COUNT_QUERY;
import static org.extension.spring.data.repository.demo.model.PersonRecord.QUERY;

public interface PersonRepository extends RepositorySpecificationExecutor<Person, String>,
        CrudRepository<Person, String> {

    @Query(value = QUERY, countQuery = COUNT_QUERY, nativeQuery = true)
    Page<PersonRecord> findPersonRecord(Pageable pageable);
}
