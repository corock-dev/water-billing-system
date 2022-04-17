package com.nhnacademy.wbs.repository;

import com.nhnacademy.wbs.service.CsvDataParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TariffsTest {
    private Tariffs tariffs;

    @BeforeEach
    void setUp() {
        // tariffs = new DefaultTariffs(new CsvDataParser());
    }

    @Test
    void load(String ext) {
        tariffs.load(ext);
    }

    @Test
    void findTariffsByUsage() {
        tariffs.findTariffsByUsage(1_000);
    }

    @Test
    void findAll() {
    }
}