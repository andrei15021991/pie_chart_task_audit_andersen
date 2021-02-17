package com.andersen.piechart;

import com.andersen.piechart.entity.DataTable;
import com.andersen.piechart.entity.PieChart;
import com.andersen.piechart.repository.PieChartRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.stream.IntStream;

@SpringBootApplication
public class PieChartApplication {

    public static void main(String[] args) {
        SpringApplication.run(PieChartApplication.class, args);
    }

    /**
     @Bean CommandLineRunner run(PieChartRepository pieChartRepository) {
     return args -> IntStream.rangeClosed(1, 60).forEach(i -> {
     PieChart pieChart = new PieChart();
     pieChart.setTitle("title " + i);
     pieChart.setDescription("description " + i);
     pieChart.setInfoIconUrl("http://url" + i);

     DataTable dataTable1 = new DataTable();
     dataTable1.setItem("item " + i);
     dataTable1.setValue((double) i);

     DataTable dataTable2 = new DataTable();
     dataTable2.setItem("item " + i);
     dataTable2.setValue((double) i);

     pieChart.setDataTables(Arrays.asList(dataTable1, dataTable2));

     pieChartRepository.save(pieChart);
     });
     }
     */
}
