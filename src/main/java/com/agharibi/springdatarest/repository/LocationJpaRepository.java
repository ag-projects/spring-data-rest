package com.agharibi.springdatarest.repository;

import com.agharibi.springdatarest.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationJpaRepository extends JpaRepository<Location, Long> {

    /**
     *
     * @param stateName
     * @return
     */
    List<Location> findByStateIgnoreCaseStartingWith(String stateName);

    /**
     *
     * @param stateName
     * @return
     */
    Location findFirstByStateIgnoreCaseStartingWith(String stateName);

    /**
     *
     * @param stateName
     * @return
     */
    List<Location> findByStateNotLikeOrderByStateAsc(String stateName);

    /**
     *
     * @param value
     * @param value2
     * @return
     */
    List<Location> findByStateIsOrCountryEquals(String value, String value2);

    /**
     *
     * @param state
     * @return
     */
    List<Location> findByStateNot(String state);
}
