package com.agharibi.springdatarest.repository;

import com.agharibi.springdatarest.models.ModelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelTypeJpaRepository extends JpaRepository<ModelType, Long> {

    List<ModelType> findByNameIsNull();
}
