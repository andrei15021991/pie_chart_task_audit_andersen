package com.andersen.piechart.service.impl;

import com.andersen.piechart.repository.DataTableRepository;
import com.andersen.piechart.service.DataTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataTableServiceImpl implements DataTableService {

    @Autowired
    private DataTableRepository dataTableRepository;

    @Override
    public void deleteDataTableById(long id) {
        dataTableRepository.deleteById(id);
    }
}
