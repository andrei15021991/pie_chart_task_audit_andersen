package com.andersen.piechart.service.impl;

import com.andersen.piechart.dto.PieChartDTO;
import com.andersen.piechart.entity.DataTable;
import com.andersen.piechart.entity.PieChart;
import com.andersen.piechart.repository.PieChartRepository;
import com.andersen.piechart.service.PieChartService;
import com.andersen.piechart.service.util.ServiceConverterToDTO;
import com.andersen.piechart.service.util.ServiceValidation;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PieChartServiceImplTest {

    @MockBean
    private PieChartRepository pieChartRepository;

    @Autowired
    private PieChartService pieChartService;

    @SpyBean
    private ServiceConverterToDTO serviceConverterToDTO;

    @SpyBean
    private ServiceValidation serviceValidation;

    private PieChart pieChart;

    @BeforeEach
    void init() {
        pieChart = new PieChart();
        pieChart.setId(1);
        pieChart.setTitle("title");
        pieChart.setDescription("description");
        pieChart.setInfoIconUrl("url");

        DataTable dataTable = new DataTable();
        dataTable.setId(1);
        dataTable.setItem("Item");
        dataTable.setValue(3.0);

        pieChart.setDataTables(Collections.singletonList(dataTable));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getAllPieChart() {
        List<PieChart> pieCharts = new ArrayList<>();
        pieCharts.add(pieChart);
        Page expectedPage = new PageImpl(pieCharts);
        when(pieChartRepository.findAll(any(Pageable.class))).thenReturn(expectedPage);
        List<PieChart> actual = pieChartService.getAllPieChart(PageRequest.of(0, 1)).getContent();
        assertEquals(pieCharts.size(), actual.size());
    }

    @Test
    void getPieChartById() {
        when(pieChartRepository.findById(anyLong())).thenReturn(Optional.of(pieChart));
        assertEquals(pieChartService.getPieChartById(1).getDescription(), pieChart.getDescription());
    }

    @Test
    void addNewPieChart() {
        doReturn(pieChart).when(serviceConverterToDTO).convertFromPieChartDTO(any(PieChartDTO.class));
        when(pieChartRepository.save(any(PieChart.class))).thenReturn(pieChart);
        PieChartDTO expected = pieChartService.addNewPieChart(new PieChartDTO());

        assertEquals(expected.getId(), pieChart.getId());


    }

    @Test
    void deletePieChartById() {
        doReturn(1L).when(serviceValidation).validateBeforeDelete(anyLong());
        pieChartService.deletePieChartById(1);
        verify(pieChartRepository, times(1)).deleteById(anyLong());

    }
}