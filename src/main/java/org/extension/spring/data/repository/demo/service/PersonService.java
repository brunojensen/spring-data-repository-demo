package org.extension.spring.data.repository.demo.service;

import org.extension.spring.data.repository.demo.model.PersonContactResultMapping;
import org.extension.spring.data.repository.demo.model.PersonRecord;
import org.extension.spring.data.repository.demo.model.Person;
import org.extension.spring.data.repository.demo.repository.PersonRepository;
import org.extension.spring.data.repository.demo.repository.specification.ByPersonContactUsingTypedNativeSpecification;
import org.extension.spring.data.repository.demo.repository.specification.ByPersonUsingTypedNativeSpecification;
import org.extension.spring.data.repository.demo.repository.specification.ByPersonUsingTypedQuerySpecification;
import org.extension.spring.data.repository.specification.TypedQuerySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Page<Person> searchBy(final Person person, final Pageable pageable) {
        return repository.findAll(new ByPersonUsingTypedQuerySpecification(person), pageable);
    }

    public List<Person> searchBy(final Person person) {
        return repository.findAll(new ByPersonUsingTypedQuerySpecification(person));
    }

    /**
     * Uses {@link org.springframework.data.jpa.repository.support.SimpleJpaRepository}
     * implementation
     */
    public Person findById(String id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Uses {@link org.extension.spring.data.repository.specification.TypedNativeQuerySpecification}
     * combined with {@link org.extension.spring.data.repository.annotations.TypedAsSqlResultSetMapping}
     * to use SqlResultMapping to serialize the query result into the pre-defined object.
     */
    public List<PersonContactResultMapping> findAll2() {
        return repository.findAll(new ByPersonContactUsingTypedNativeSpecification(), PersonContactResultMapping.class);
    }

    /**
     * Still capable to quering using annotation {@link org.springframework.data.jpa.repository.Query} and
     * interface projection
     */
    public Page<PersonRecord> findAll(final Pageable pageable) {
        return repository.findPersonRecord(pageable);
    }

    /**
     * Uses {@link org.extension.spring.data.repository.specification.TypedNativeQuerySpecification}
     *      * for count
     */
    public List<Person> findAll() {
        return repository.findAll((TypedQuerySpecification) () -> "SELECT p FROM Person p");
    }

    /**
     * Uses {@link org.extension.spring.data.repository.specification.TypedNativeQuerySpecification} with
     * SELECT * ... for counting.
     *
     * The query will be replaced with SELECT count(*)... at execution time.
     */
    public long count() {
        return repository.count(new ByPersonUsingTypedNativeSpecification());
    }

    /**
     * Uses {@link org.extension.spring.data.repository.specification.NativeQuerySpecification} with
     * SELECT * ... for counting.
     *
     * The query will be replaced with SELECT count(*)... at execution time.
     */
    public long countBy(final Person person) {
        return repository.count(new ByPersonUsingTypedQuerySpecification(person));
    }
    @Transactional
    public void save(Person person) {
        repository.save(person);
    }
}
