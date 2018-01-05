package com.agharibi.springdatarest.repository;

public class ModelJpaRepositoryImpl implements ModelJpaRepositoryCustom {

    @Override
    public void aCustomMethod() {
        System.out.printf("Custom repository method");
    }
}
