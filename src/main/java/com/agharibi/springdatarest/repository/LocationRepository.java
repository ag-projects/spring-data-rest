package com.agharibi.springdatarest.repository;


import com.agharibi.springdatarest.models.Location;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class LocationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Create a location
     * @param location
     * @return location
     */
    public Location create(Location location) {
        entityManager.persist(location);
        entityManager.flush();
        return location;
    }

    /**
     * Update a location
     * @param location
     * @return updated location
     */
    public Location update(Location location) {
        Location updatedLocation = entityManager.merge(location);
        entityManager.flush();
        return updatedLocation;
    }

    /**
     * Delete a loaction
     * @param location
     */
    public void delete(Location location) {
        entityManager.remove(location);
        entityManager.flush();
    }

    /**
     * Find by id
     * @param id
     * @return location
     */
    public Location find(Long id) {
        return entityManager.find(Location.class, id);
    }

    /**
     * get location by state name
     * @param name
     * @return list of locations
     */
    public List<Location> getLocationByStateName(String name) {
        Query query = entityManager.createQuery("select loc from Location loc where loc.state like :state");
        query.setParameter("state", name + "%");
        return query.getResultList();

    }
}
