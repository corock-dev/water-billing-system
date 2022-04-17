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

                writer.write("불러올 파일 확장자를 선택하세요(1. csv / 2 json)"
                    + System.lineSeparator() + "> ");
                writer.flush();
                context.getBean("defaultTariffs", Tariffs.class).load(reader.readLine());

                while (true) {
                    writer.write("사용량을 입력하세요." + System.lineSeparator() + "> ");
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
