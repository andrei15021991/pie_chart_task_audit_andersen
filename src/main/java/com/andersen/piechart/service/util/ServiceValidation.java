package com.andersen.piechart.service.util;

import com.andersen.piechart.entity.DataTable;
import com.andersen.piechart.entity.PieChart;
import com.andersen.piechart.exception.PieChartException;
import com.andersen.piechart.exception.ValidateFieldException;
import com.andersen.piechart.repository.PieChartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ServiceValidation {

    @Autowired
    private PieChartRepository pieChartRepository;

    public void validatePieChartObject(PieChart pieChart) {
        if (pieChart.getDescription().trim().length() > 250 || pieChart.getDescription().trim().isEmpty()) {
            throw new ValidateFieldException("description should not be empty and length should be <= 250");
        }
        if (pieChart.getTitle().trim().isEmpty() || pieChart.getTitle().trim().length() > 70) {
            throw new ValidateFieldException("title should not be empty and length should be <= 70");
        }
        if (pieChart.getInfoIconUrl().trim().isEmpty() || pieChart.getInfoIconUrl().trim().length() > 2048) {
            throw new ValidateFieldException("info url should not be empty and length should be <= 2048");
        }

        Optional<DataTable> item = pieChart.getDataTables().stream()
                .filter(dt -> dt.getItem().trim().isEmpty() || dt.getItem().trim().length() > 30)
                .findFirst();

        if (item.isPresent()) {
            throw new ValidateFieldException("item should not be empty and length should be <= 30");
        }

        Optional<DataTable> value = pieChart.getDataTables().stream()
                .filter(dt -> dt.getValue() < 0 || dt.getValue() >= 10000)
                .findFirst();

        if (value.isPresent()) {
            throw new ValidateFieldException("value should not be < 0 and >= 10000");
        }


    }

    public long validateBeforeDelete(long id) {
        Optional<PieChart> pieChart = pieChartRepository.findById(id);
        if (!pieChart.isPresent()) {
            throw new PieChartException("wrong pie-chart id " + id);
        } else {
            return id;
        }
    }
}
