package com.nhnacademy.wbs.repository;

import java.util.stream.Stream;

/**
 * 상수도 사용 요금 서비스
 */
public interface WaterBills {
    Stream<WaterBill> calculateWaterBills(int usage);
}
