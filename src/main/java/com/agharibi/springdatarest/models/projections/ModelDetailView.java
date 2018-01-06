package com.agharibi.springdatarest.models.projections;


import com.agharibi.springdatarest.models.Model;
import com.agharibi.springdatarest.models.ModelType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

@Projection(name = "modelDetailView", types = {Model.class})
public interface ModelDetailView {

    BigDecimal getPrice();
    ModelType getModelType();
    int getFrets();
    String getWoodType();

    @Value("#{target.name}")
    String getModelName();

    @Value("#{target.manufacturer.name}")
    String getManufacturerName();

    @Value("#{target.manufacturer.name.split(' ')[0]} #{target.name}")
    String getFullName();
}
