package com.spring.workshop.databaseJpa.repository;

import com.spring.workshop.databaseJpa.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimplifiedPersonJpaRepository
        extends JpaRepository<PersonEntity, Integer> {
}
