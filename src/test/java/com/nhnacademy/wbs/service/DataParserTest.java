package com.nhnacademy.wbs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataParserTest {
    private DataParser dataParser;

    @BeforeEach
    void setUp() {
        dataParser = new CsvDataParser();
    }

    @Test
    void parse() {
        // dataParser.parse();
    }
}