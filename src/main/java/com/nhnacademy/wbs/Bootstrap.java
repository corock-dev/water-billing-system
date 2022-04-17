package com.nhnacademy.wbs;

import static java.lang.Integer.parseInt;

import com.nhnacademy.wbs.repository.Tariffs;
import com.nhnacademy.wbs.repository.WaterBills;
import com.nhnacademy.wbs.service.ResultReport;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Bootstrap {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context
                 = new AnnotationConfigApplicationContext("com.nhnacademy.wbs")) {

            // ResultReport resultReport = new DefaultResultReport();
            // context.getBean("resultReport", ResultReport.class);
            context.getBean("defaultResultReport", ResultReport.class);

            // Tariffs tariffs = new DefaultTariffs();
            // tariffs.load();
            // context.getBean("defaultTariffs", Tariffs.class).load();

            // WaterBills waterBills = new DefaultWaterBills(tariffs);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

                // context.getBean("csvDataParser", DataParser.class);
                Tariffs tariffs = context.getBean("defaultTariffs", Tariffs.class);
                tariffs.load();

                writer.write("> ");
                writer.flush();
                tariffs.findTariffsByUsage(parseInt(reader.readLine()));

                context.getBean("defaultWaterBills", WaterBills.class);
                    // .calculateWaterBills();
                // resultReport.report(bill);

            } catch (IOException e) {
                // e.printStackTrace();
            }
        }

    }
}
