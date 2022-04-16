package com.nhnacademy.wbs.repository;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.core.io.ClassPathResource;

/**
 * 기본 요금표 저장소
 */
public class DefaultTariffs implements Tariffs {
    private final Collection<Tariff> tariffs = new ArrayList<>();

    @Override
    public void load() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
            new ClassPathResource("data/Tariff_20220331.csv").getInputStream()))) {

            reader.lines()
                  .skip(1)
                  .map(line -> line.replaceAll(" ", ""))
                  .map(line -> line.split(","))
                  .forEach(this::add);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void add(String[] tariff) {
        tariffs.add(new Tariff(parseInt(tariff[0]), tariff[1], tariff[2], parseInt(tariff[3]),
            parseInt(tariff[4]), parseInt(tariff[5]), null, null));
    }
}
