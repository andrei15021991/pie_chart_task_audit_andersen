package com.andersen.piechart.controller;

import com.andersen.piechart.dto.PieChartDTO;
import com.andersen.piechart.entity.PieChart;
import com.andersen.piechart.service.DataTableService;
import com.andersen.piechart.service.PieChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/pie-charts")
public class PieChartController {

    @Autowired
    private PieChartService pieChartService;

    @Autowired
    private DataTableService dataTableService;

    @GetMapping
    public Page<PieChart> getAll(@PageableDefault(page = 0, size = 50) Pageable pageable) {
        return pieChartService.getAllPieChart(pageable);
    }

    @GetMapping("{id}")
    public PieChartDTO getById(@PathVariable long id) {
        return pieChartService.getPieChartById(id);
    }

    @PostMapping
    public PieChartDTO addNew(@RequestBody @Valid PieChart pieChart) {
        return pieChartService.addNewPieChart(pieChart);
    }

    @PutMapping
    public PieChartDTO updateExistingObject(@RequestBody @Valid PieChart pieChart) {
        return pieChartService.updatePieChart(pieChart);
    }

    @DeleteMapping("{id}")
    public long deleteById(@PathVariable long id) {
        return pieChartService.deletePieChartById(id);
    }

    @DeleteMapping("{pie-chart-id}/data-table/{id}")
    public PieChartDTO deleteData(@PathVariable("pie-chart-id") long pieChartId, @PathVariable long id) {
        dataTableService.deleteDataTableById(id);
        return pieChartService.getPieChartById(pieChartId);
    }
}
