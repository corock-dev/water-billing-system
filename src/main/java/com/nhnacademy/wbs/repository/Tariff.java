package com.nhnacademy.wbs.repository;


public class Tariff {
    /**
     * 순번
     */
    private final int no;

    /**
     * 지자체명
     */
    private final String city;

    /**
     * 업종
     */
    private final String sector;

    /**
     * 단계
     */
    private final int stage;

    /**
     * 구간시작(세제곱미터)
     */
    private final int startInterval;

    /**
     * 구간끝(세제곱미터)
     */
    private final int endInterval;

    /**
     * 구간금액(원)
     */
    private final Money intervalAmount;

    /**
     * 단계별 기본요금(원)
     */
    private final Money basicCharge;

    public Tariff(int no, String city, String sector, int stage,
                  int startInterval, int endInterval, Money intervalAmount, Money basicCharge) {
        this.no = no;
        this.city = city;
        this.sector = sector;
        this.stage = stage;
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.intervalAmount = intervalAmount;
        this.basicCharge = basicCharge;
    }
}
