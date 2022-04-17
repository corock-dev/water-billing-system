package com.nhnacademy.wbs.service;

import com.nhnacademy.wbs.repository.WaterBill;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class DefaultResultReport implements ResultReport {
    @Override
    public void report(Stream<WaterBill> data) {
        data.forEach(System.out::println);
    }
}
