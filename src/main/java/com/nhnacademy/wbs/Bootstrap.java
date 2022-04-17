package com.nhnacademy.wbs;

import static java.lang.Integer.parseInt;

import com.nhnacademy.wbs.repository.Tariffs;
import com.nhnacademy.wbs.repository.WaterBill;
import com.nhnacademy.wbs.repository.WaterBills;
import com.nhnacademy.wbs.service.DataParser;
import com.nhnacademy.wbs.service.ResultReport;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Bootstrap {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context
                 = new AnnotationConfigApplicationContext("com.nhnacademy.wbs")) {

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

                context.getBean("csvDataParser", DataParser.class);

                Tariffs tariffs = context.getBean("defaultTariffs", Tariffs.class);
                tariffs.load();

                writer.write("> ");
                writer.flush();
                Stream<WaterBill> data =
                    context.getBean("defaultWaterBills", WaterBills.class)
                           .calculateWaterBills(parseInt(reader.readLine()));

                context.getBean("defaultResultReport", ResultReport.class).report(data);


            } catch (IOException e) {
                // FIXME
                // e.printStackTrace();
            }
        }

    }
}
