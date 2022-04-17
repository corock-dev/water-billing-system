package com.nhnacademy.wbs.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tariff {
    @JsonProperty(value = "순번")
    private int no;

    @JsonProperty(value = "지자체명")
    private String city;

    @JsonProperty(value = "업종")
    private String sector;

    @JsonProperty(value = "단계")
    private int stage;

    @JsonProperty(value = "구간시작(세제곱미터)")
    private int intervalFrom;

    @JsonProperty(value = "구간끝(세제곱미터)")
    private int intervalTo;

    @JsonProperty(value = "구간금액(원)")
    private int intervalAmount;

    @JsonProperty(value = "단계별 기본요금(원)")
    private String unitPrice;

    public Tariff() {
    }

    public Tariff(int no, String city, String sector, int stage,
                  int intervalFrom, int intervalTo, int intervalAmount, String unitPrice) {
        this.no = no;
        this.city = city;
        this.sector = sector;
        this.stage = stage;
        this.intervalFrom = intervalFrom;
        this.intervalTo = intervalTo;
        this.intervalAmount = intervalAmount;
        this.unitPrice = unitPrice;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    public int getIntervalFrom() {
        return intervalFrom;
    }

    public int getIntervalTo() {
        return intervalTo;
    }

    public int getIntervalAmount() {
        return intervalAmount;
    }

    public int getNo() {
        return no;
    }

    public int getStage() {
        return stage;
    }

    public String getUnitPrice() {
        return unitPrice;
    }
}
