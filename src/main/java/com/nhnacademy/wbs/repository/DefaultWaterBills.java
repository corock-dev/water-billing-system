package com.nhnacademy.wbs.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DefaultWaterBills implements WaterBills {
    private final Tariffs tariffs;

    public DefaultWaterBills(Tariffs tariffs) {
        this.tariffs = tariffs;
    }

    @Override
    public void calculateWaterBills(int usage) {
        // 요금을 계산한다

        tariffs.load();
        tariffs.findTariffsByUsage(usage);
    }
}
