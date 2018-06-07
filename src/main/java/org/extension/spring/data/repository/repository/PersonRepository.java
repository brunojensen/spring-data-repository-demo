package org.extension.spring.data.repository.repository;

import org.extension.spring.data.repository.model.Person;
import org.extension.spring.data.repository.model.PersonRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import spring.data.repository.RepositorySpecificationExecutor;

import static org.extension.spring.data.repository.model.PersonRecord.COUNT_QUERY;
import static org.extension.spring.data.repository.model.PersonRecord.QUERY;

public interface PersonRepository extends RepositorySpecificationExecutor<Person, String>,
        CrudRepository<Person, String> {

    @Query(value = QUERY, countQuery = COUNT_QUERY, nativeQuery = true)
    Page<PersonRecord> findPersonRecord(Pageable pageable);
}
