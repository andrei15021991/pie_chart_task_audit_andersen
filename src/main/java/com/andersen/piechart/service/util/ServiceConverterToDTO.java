package com.andersen.piechart.service.util;

import com.andersen.piechart.dto.PieChartDTO;
import com.andersen.piechart.entity.PieChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceConverterToDTO {

    @Autowired
    private ServiceValidation serviceValidation;

    public PieChartDTO convertToPieChartDTO(PieChart pieChart) {
        return new PieChartDTO(
                pieChart.getId(),
                pieChart.getTitle(),
                pieChart.getInfoIconUrl(),
                pieChart.getDescription(),
                pieChart.getDataTables());
    }

    public PieChart convertFromPieChartDTO(PieChartDTO pieChartDTO) {
        PieChart pieChart = new PieChart(
                pieChartDTO.getId(),
                pieChartDTO.getTitle(),
                pieChartDTO.getInfoIconUrl(),
                pieChartDTO.getDescription(),
                pieChartDTO.getDataTables());

        serviceValidation.validatePieChartObject(pieChart);

        return pieChart;
    }
}
