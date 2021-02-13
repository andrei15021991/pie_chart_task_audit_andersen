package com.andersen.piechart.service;

import com.andersen.piechart.dto.PieChartDTO;
import com.andersen.piechart.entity.PieChart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PieChartService {

    Page<PieChart> getAllPieChart(Pageable pageable);

    PieChartDTO getPieChartById(long id);

    PieChartDTO addNewPieChart(PieChartDTO pieChartDTO);

    PieChartDTO updatePieChart(PieChartDTO pieChartDTO);

    Long deletePieChartById(long id);
}
