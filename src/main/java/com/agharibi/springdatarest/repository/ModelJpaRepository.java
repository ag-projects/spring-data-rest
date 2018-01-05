package com.agharibi.springdatarest.repository;

import com.agharibi.springdatarest.models.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ModelJpaRepository extends JpaRepository<Model, Long>, ModelJpaRepositoryCustom {

    /**
     *
     * @param low
     * @param high
     * @return
     */
    List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal low, BigDecimal high);

    /**
     *
     * @param types
     * @return
     */
    List<Model> findByModelTypeNameIn(List<String> types);

    @Query("select m from Model m where m.price >= :lowest and m.price <= :highest and m.woodType like :wood")
    Page<Model> queryByPriceRangeAAndWoodType(@Param("lowest") BigDecimal lowest,
                                              @Param("highest") BigDecimal highest,
                                              @Param("wood") String wood,
                                              Pageable page);

    /**
     *
     * @param name
     * @return
     */
    List<Model> findAllModelsByType(@Param("name") String name);

}
