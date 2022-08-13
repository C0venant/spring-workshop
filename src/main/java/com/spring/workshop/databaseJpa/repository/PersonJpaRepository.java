package com.spring.workshop.databaseJpa.repository;


import com.spring.workshop.databaseJpa.entity.PersonEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

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

    public void delete(int id) {
        var person = findById(id);
        entityManager.remove(person);
    }

    public List<PersonEntity> findAll() {
        //find_all is defined in class annotation
        TypedQuery<PersonEntity> namedQuery =
                entityManager.createNamedQuery("find_all", PersonEntity.class);
        return  namedQuery.getResultList();
    }
}
