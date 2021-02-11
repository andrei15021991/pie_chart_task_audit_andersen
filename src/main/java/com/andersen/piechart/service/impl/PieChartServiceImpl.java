package com.andersen.piechart.service.impl;

import com.andersen.piechart.dto.PieChartDTO;
import com.andersen.piechart.entity.PieChart;
import com.andersen.piechart.exception.PieChartException;
import com.andersen.piechart.repository.PieChartRepository;
import com.andersen.piechart.service.PieChartService;
import com.andersen.piechart.service.util.ServiceConverterToDTO;
import com.andersen.piechart.service.util.ServiceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PieChartServiceImpl implements PieChartService {

    @Autowired
    private PieChartRepository pieChartRepository;

    @Autowired
    private ServiceConverterToDTO serviceConverterToDTO;

    @Autowired
    private ServiceValidation serviceValidation;

    @Transactional(readOnly = true)
    @Override
    public Page<PieChart> getAllPieChart(Pageable pageable) {
        return pieChartRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public PieChartDTO getPieChartById(long id) {
        PieChart pieChart = pieChartRepository.findById(id).orElseThrow(() -> new PieChartException("wrong user id " + id));
        return serviceConverterToDTO.convertToPieChartDTO(pieChart);
    }

    @Transactional
    @Override
    public PieChartDTO addNewPieChart(PieChart pieChart) {
        serviceValidation.validatePieChartObject(pieChart);
        PieChart newPieChart = pieChartRepository.save(pieChart);
        return serviceConverterToDTO.convertToPieChartDTO(pieChart);
    }

    @Transactional
    @Override
    public PieChartDTO updatePieChart(PieChart pieChart) {
        serviceValidation.validatePieChartObject(pieChart);
        PieChart update = pieChartRepository.save(pieChart);
        return serviceConverterToDTO.convertToPieChartDTO(update);
    }

    @Transactional
    @Override
    public Long deletePieChartById(long id) {
        long validId = serviceValidation.validateBeforeDelete(id);
        pieChartRepository.deleteById(validId);
        return validId;
    }
}
