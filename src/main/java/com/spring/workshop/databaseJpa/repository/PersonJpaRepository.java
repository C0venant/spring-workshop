package com.spring.workshop.databaseJpa.repository;


import com.spring.workshop.databaseJpa.entity.PersonEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional//transaction management
public class PersonJpaRepository {

    @PersistenceContext // all operations should go through here
    EntityManager entityManager;

    public PersonEntity findById(int id) {
        return entityManager.find(PersonEntity.class, id);
    }

    //insert is same
    public PersonEntity update(PersonEntity person) {
        return entityManager.merge(person);
    }

}
