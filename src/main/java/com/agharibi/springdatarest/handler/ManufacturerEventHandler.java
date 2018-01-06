package com.agharibi.springdatarest.handler;


import com.agharibi.springdatarest.models.Manufacturer;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Manufacturer.class)
public class ManufacturerEventHandler {


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @HandleBeforeCreate
    public void handleBeforeCreate(Manufacturer manufacturer) {

        // do a check to see if the name is valid manufacturer

        // auditing

        // only allow new manufacturer to be created in the active state.
        if(!manufacturer.getActive()) {
            throw new IllegalArgumentException("New Manufacturer must be 'active'");
        }

    }

}
