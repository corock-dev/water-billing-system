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
                context.getBean("jsonDataParser", DataParser.class);

                context.getBean("defaultTariffs", Tariffs.class).load();

                while (true) {
                    writer.write("> ");
                    writer.flush();
                    Stream<WaterBill> data =
                        context.getBean("defaultWaterBills", WaterBills.class)
                               .calculateWaterBills(parseInt(reader.readLine()));

                    context.getBean("defaultResultReport", ResultReport.class).report(data);
                }

            } catch (IOException e) {
                throw new IllegalStateException("데이터 로드가 정상적으로 완료되지 않았습니다. " + e.getMessage());
            }
        }
    }
}
