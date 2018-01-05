package com.agharibi.springdatarest.repository;

import com.agharibi.springdatarest.models.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository
public class ManufacturerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ManufacturerJpaRepository manufacturerJpaRepository;

    /**
     *
     * @param manufacturer
     * @return
     */
    public Manufacturer create(Manufacturer manufacturer) {
        return manufacturerJpaRepository.saveAndFlush(manufacturer);
    }

    /**
     *
     * @param manufacturer
     * @return
     */
    public Manufacturer update(Manufacturer manufacturer) {
        return manufacturerJpaRepository.saveAndFlush(manufacturer);
    }

    /**
     *
     * @param manufacturer
     */
    public void delete(Manufacturer manufacturer) {
        manufacturerJpaRepository.delete(manufacturer);
    }

    /**
     *
     * @param id
     * @return
     */
    public Manufacturer find(Long id) {
        return manufacturerJpaRepository.findOne(id);
    }

    /**
     *
     * @param date
     * @return
     */
    public List<Manufacturer> getManufacturersFoundedBeforeDate(Date date) {
        return manufacturerJpaRepository.findByFoundedDateBefore(date);
    }

    /**
     *
     * @param name
     * @return
     */
    public Manufacturer getManufacturerByName(String name) {
        Query query = entityManager.createQuery("select m from Manufacturer m where m.name like :name");
        query.setParameter("name", name + "%");
        return (Manufacturer) query.getSingleResult();
    }

    /**
     *
     * @param modelType
     * @return
     */
//    public List<Manufacturer> getManufacturersThatSellModelsOfType(String modelType) {
//        return manufacturerJpaRepository.getAllThatSellAcoustics(modelType);
//    }

    public void setManufacturerJpaRepository(ManufacturerJpaRepository manufacturerJpaRepository) {
        this.manufacturerJpaRepository = manufacturerJpaRepository;
    }
}
