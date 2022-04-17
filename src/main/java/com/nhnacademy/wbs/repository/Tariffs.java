package com.nhnacademy.wbs.repository;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * 요금표 저장소
 */
public interface Tariffs {
    void load(String ext);

    Stream<Tariff> findTariffsByUsage(int usage);

    Collection<Tariff> findAll();
}
