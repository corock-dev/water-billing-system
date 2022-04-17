package com.nhnacademy.wbs.service;

import static java.lang.Integer.parseInt;

import com.nhnacademy.wbs.repository.Tariff;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service(value = "csvDataParser")
public class CsvDataParser implements DataParser {
    @Override
    public Collection<Tariff> parse(String path) {
        Collection<Tariff> results = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(new ClassPathResource(path).getInputStream()))) {
            reader.lines()
                  .skip(1)
                  .map(line -> line.replaceAll(" ", ""))
                  .map(line -> line.split(","))
                  .forEach(line -> results.add(this.instantiateTariff(line)));

        } catch (IOException e) {
            throw new IllegalStateException("데이터 로드가 정상적으로 완료되지 않았습니다. " + e.getMessage());
        }

        return results;
    }

    private Tariff instantiateTariff(String[] tariff) {
        return new Tariff(parseInt(tariff[0]), tariff[1], tariff[2], parseInt(tariff[3]),
            parseInt(tariff[4]), parseInt(tariff[5]), parseInt(tariff[6]), "");
    }
}
