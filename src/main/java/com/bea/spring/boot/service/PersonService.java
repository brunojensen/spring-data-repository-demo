package com.bea.spring.boot.service;

import com.bea.spring.boot.model.Person;
import com.bea.spring.boot.repository.PersonRepository;
import com.bea.spring.repository.specification.CriteriaQuerySpecification;
import com.bea.spring.repository.specification.NativeQuerySpecification;
import com.bea.spring.repository.specification.TypedQuerySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Page<Person> searchBy(final Pageable pageable) {
        return repository.findAllBy(new TypedQuerySpecification<Person>() {
            @Override
            public String query() {
                return "SELECT p FROM Person p JOIN p.contacts c";
            }

            @Override
            public void toPredicate(Query query) {
            }
        }, pageable);
    }

    public List<Person> searchBy(final Person person) {
        return repository.findAllBy(new TypedQuerySpecification<Person>() {
            @Override
            public String query() {
                return "SELECT p FROM Person p JOIN FETCH p.contacts c";
            }

            @Override
            public void toPredicate(Query query) {
            }
        });
    }

    public long countBy(final Person person) {
        return repository.count(new TypedQuerySpecification<Person>() {
            @Override
            public String query() {
                return "SELECT count(*) FROM Person";
            }

            @Override
            public void toPredicate(Query query) {
            }
        });
    }


    public long countBy() {
        return repository.count(new NativeQuerySpecification() {
            @Override
            public String query() {
                return "SELECT count(*) FROM Person";
            }

            @Override
            public void toPredicate(Query query) {
            }
        });
    }

    public Person findById(String id) {
        return repository.findBy(new CriteriaQuerySpecification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("email"), id);
            }
        });
    }
}
