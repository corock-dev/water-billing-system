package com.nhnacademy.wbs.repository;

import com.nhnacademy.wbs.service.DataParser;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 기본 요금표 저장소
 */
@Repository
public class DefaultTariffs implements Tariffs {
    private Collection<Tariff> tariffs;

    private final DataParser jsonDataParser;
    private final DataParser csvDataParser;

    @Autowired
    public DefaultTariffs(DataParser jsonDataParser, DataParser csvDataParser) {
        this.jsonDataParser = jsonDataParser;
        this.csvDataParser = csvDataParser;
    }

    @Override
    public void load(String ext) {
        if (Objects.equals("csv", ext)) {
            tariffs = csvDataParser.parse("data/Tariff_20220331.csv");
            return;
        }
        tariffs = jsonDataParser.parse("data/Tariff_20220331.json");
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
