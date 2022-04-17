package com.nhnacademy.wbs.service;

import com.nhnacademy.wbs.repository.WaterBill;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public interface ResultReport {
    void report(Stream<WaterBill> bill);
}
