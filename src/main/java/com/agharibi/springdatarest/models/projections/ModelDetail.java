package com.agharibi.springdatarest.models.projections;


import com.agharibi.springdatarest.models.Manufacturer;
import com.agharibi.springdatarest.models.Model;
import com.agharibi.springdatarest.models.ModelType;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

@Projection(name = "modelDetail", types = {Model.class})
public interface ModelDetail {

    String getName();
    BigDecimal getPrice();
    Manufacturer getManufacturer();
    ModelType getModelType();
    int getFrets();
    String getWoodType();
}
