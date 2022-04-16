package com.nhnacademy.wbs;

import com.nhnacademy.wbs.repository.DefaultTariffs;
import com.nhnacademy.wbs.repository.DefaultWaterBills;
import com.nhnacademy.wbs.repository.Tariffs;
import com.nhnacademy.wbs.repository.WaterBills;
import com.nhnacademy.wbs.service.DefaultResultReport;
import com.nhnacademy.wbs.service.ResultReport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bootstrap {
    public static void main(String[] args) {
        ResultReport resultReport = new DefaultResultReport();
        WaterBills waterBills = new DefaultWaterBills();
        Tariffs tariff = new DefaultTariffs();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            long bill = Long.parseLong(reader.readLine());
            System.out.println(bill);
        } catch (IOException e) {
            // e.printStackTrace();
        }
    }
}
