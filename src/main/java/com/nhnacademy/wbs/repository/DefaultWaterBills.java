package com.nhnacademy.wbs.repository;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultWaterBills implements WaterBills {
    private final Tariffs tariffs;

    public DefaultWaterBills(Tariffs tariffs) {
        this.tariffs = tariffs;
    }

    @Override
    public Stream<WaterBill> calculateWaterBills(int usage) {
        Collection<WaterBill> waterBills = new ArrayList<>();

        Stream<Tariff> targetTariffs = tariffs.findTariffsByUsage(usage);
        targetTariffs.forEach(tariff -> waterBills.add(instantiateWaterBills(tariff, usage)));

        return waterBills.stream()
                         .sorted(comparing(WaterBill::getBillTotal))
                         .limit(5);
    }

    private WaterBill instantiateWaterBills(Tariff tariff, int usage) {
        int amount = tariff.getIntervalAmount();
        return new WaterBill(tariff.getCity(), tariff.getSector(), amount, amount * usage);
    }
}
