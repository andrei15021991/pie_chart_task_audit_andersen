package com.andersen.piechart.controller;

import com.andersen.piechart.dto.PieChartDTO;
import com.andersen.piechart.entity.DataTable;
import com.andersen.piechart.entity.PieChart;
import com.andersen.piechart.service.DataTableService;
import com.andersen.piechart.service.PieChartService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@WebMvcTest(PieChartController.class)
public class PieChartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PieChartService pieChartService;

    @MockBean
    private DataTableService dataTableService;

    private PieChartDTO pieChartDTO;
    private PieChart pieChart;

    @BeforeEach
    public void init() {
        pieChartDTO = new PieChartDTO();
        pieChartDTO.setId(1);
        pieChartDTO.setTitle("title");
        pieChartDTO.setDescription("description");
        pieChartDTO.setInfoIconUrl("url");

        DataTable dataTable = new DataTable();
        dataTable.setId(1);
        dataTable.setItem("Item");
        dataTable.setValue(3.0);

        pieChartDTO.setDataTables(Collections.singletonList(dataTable));

        pieChart = new PieChart();
        pieChart.setId(1);
        pieChart.setTitle("title");
        pieChart.setDescription("description");
        pieChart.setInfoIconUrl("url");

        pieChart.setDataTables(Collections.singletonList(dataTable));
    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void getAllPieChart() throws Exception {
        List<PieChart> pieCharts = new ArrayList<>();
        pieCharts.add(pieChart);
        when(pieChartService.getAllPieChart(any(Pageable.class))).thenReturn(new PageImpl(pieCharts));
        String url = "/api/v1/pie-charts";
        mockMvc.perform(get(url)).andExpect(status().isOk());
    }

    @Test
    public void getPieChartById() throws Exception {
        when(pieChartService.getPieChartById(anyLong())).thenReturn(pieChartDTO);
        String url = "/api/v1/pie-charts/1";
        mockMvc.perform(get(url)).andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(pieChartDTO)));
    }

    @Test
    public void addNewPieChart() throws Exception {
        when(pieChartService.addNewPieChart(any(PieChartDTO.class))).thenReturn(pieChartDTO);
        String url = "/api/v1/pie-charts";
        String expected = objectMapper.writeValueAsString(pieChartDTO);
        mockMvc.perform(post(url).contentType("application/json")
                .content(objectMapper.writeValueAsString(pieChartDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    public void updatePieChart() throws Exception {
        when(pieChartService.updatePieChart(any(PieChartDTO.class))).thenReturn(pieChartDTO);
        String url = "/api/v1/pie-charts";
        String expected = objectMapper.writeValueAsString(pieChartDTO);
        mockMvc.perform(put(url).contentType("application/json")
                .content(objectMapper.writeValueAsString(pieChartDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    public void deletePieChartById() throws Exception {
        when(pieChartService.deletePieChartById(anyLong())).thenReturn(1L);
        String url = "/api/v1/pie-charts/1";
        mockMvc.perform(delete(url)).andExpect(status().isOk())
                .andExpect(content().string("1"));
    }
}
