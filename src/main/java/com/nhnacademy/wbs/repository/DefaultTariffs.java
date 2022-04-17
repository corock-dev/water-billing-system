package com.nhnacademy.wbs.repository;

import com.nhnacademy.wbs.service.DataParser;
import java.util.Collection;
import java.util.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * 기본 요금표 저장소
 */
@Repository
@Lazy
public class DefaultTariffs implements Tariffs {
    private Collection<Tariff> tariffs;
    private final DataParser dataParser;

    @Autowired
    public DefaultTariffs(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    @Override
    public void load() {
        tariffs = dataParser.parse("data/Tariff_20220331.csv");
    }

    @Override
    public void findTariffsByUsage(int usage) {
        // endInterval - startInterval
        tariffs.stream()
            .filter(tariff -> tariff.getIntervalFrom() <= usage && usage <= tariff.getIntervalTo())
            .limit(5)
            // .sorted(Comparator.comparing(tariff -> tariff.getBillTotal()))
            .forEach(tariff -> tariff.getIntervalTo());
    }

    @Override
    public Collection<Tariff> findAll() {
        return tariffs;
    }
}
