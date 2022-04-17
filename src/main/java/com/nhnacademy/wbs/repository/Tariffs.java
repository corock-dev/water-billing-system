package com.nhnacademy.wbs.repository;

import java.util.Collection;

/**
 * 요금표 저장소
 */
public interface Tariffs {
    void load();

    void findTariffsByUsage(int usage);

    Collection<Tariff> findAll();
}
