package com.nhnacademy.wbs.service;

import com.nhnacademy.wbs.repository.Tariff;
import java.util.Collection;

public interface DataParser {
    Collection<Tariff> parse(String path);
}
