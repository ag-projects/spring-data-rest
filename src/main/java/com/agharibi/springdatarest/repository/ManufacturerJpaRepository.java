package com.agharibi.springdatarest.repository;

import com.agharibi.springdatarest.models.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@RepositoryRestResource(path = "manu", collectionResourceRel = "manu")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface ManufacturerJpaRepository extends JpaRepository<Manufacturer, Long> {

    List<Manufacturer> findByFoundedDateBefore(Date date);

    List<Manufacturer> findByActiveTrue();

    List<Manufacturer> findByActiveFalse();

    List<Manufacturer> getAllThatSellAcoustics(String name);
}
