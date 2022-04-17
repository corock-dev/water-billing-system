package com.nhnacademy.wbs.repository;

import com.nhnacademy.wbs.service.DataParser;
import java.util.Collection;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * 기본 요금표 저장소
 */
@Repository
public class DefaultTariffs implements Tariffs {
    private Collection<Tariff> tariffs;

    private final DataParser dataParser;

    @Autowired
    public DefaultTariffs(@Qualifier(value = "jsonDataParser") DataParser dataParser) {
        this.dataParser = dataParser;
    }

    @Override
    public void load() {
        // tariffs = dataParser.parse("data/Tariff_20220331.csv");
        tariffs = dataParser.parse("data/Tariff_20220331.json");
    }

    @Override
    public Stream<Tariff> findTariffsByUsage(int usage) {
        return tariffs.stream()
                      .filter(t -> t.getIntervalFrom() <= usage && usage <= t.getIntervalTo());
    }

    @Override
    public Collection<Tariff> findAll() {
        return tariffs;
    }
}
