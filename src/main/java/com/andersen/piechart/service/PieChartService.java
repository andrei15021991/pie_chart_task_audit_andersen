package com.andersen.piechart.service;

import com.andersen.piechart.dto.PieChartDTO;
import com.andersen.piechart.entity.PieChart;
import com.andersen.piechart.exception.PieChartException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PieChartService {

    Page<PieChart> getAllPieChart(Pageable pageable);

    PieChartDTO getPieChartById(long id);

    PieChartDTO addNewPieChart(PieChart pieChart);

    PieChartDTO updatePieChart(PieChart pieChart);

    Long deletePieChartById(long id);
}
