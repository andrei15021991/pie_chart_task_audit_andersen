package com.andersen.piechart.service.util;

import com.andersen.piechart.dto.PieChartDTO;
import com.andersen.piechart.entity.PieChart;
import org.springframework.stereotype.Component;

@Component
public class ServiceConverterToDTO {

    public PieChartDTO convertToPieChartDTO(PieChart pieChart) {
        return new PieChartDTO(
                pieChart.getId(),
                pieChart.getTitle(),
                pieChart.getInfoIconUrl(),
                pieChart.getDescription(),
                pieChart.getDataTables());
    }
}
