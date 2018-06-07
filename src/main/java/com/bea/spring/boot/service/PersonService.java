package com.bea.spring.boot.service;

import com.bea.spring.boot.model.Person;
import com.bea.spring.boot.repository.PersonRepository;
import com.bea.spring.repository.CriteriaQuerySpecification;
import com.bea.spring.repository.TypedQuerySpecification;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Person> searchBy(final Person person) {
        return repository.searchBy(new TypedQuerySpecification<Person>() {
            @Override
            public String query() {
                return "FROM Person";
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

    public Person findById(String id) {
        return repository.findBy(new CriteriaQuerySpecification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> r, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                return cb.equal(r.get("email"), id);
            }
        });
    }
}
