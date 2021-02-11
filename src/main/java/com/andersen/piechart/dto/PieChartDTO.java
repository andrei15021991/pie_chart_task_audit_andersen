package com.andersen.piechart.dto;

import com.andersen.piechart.entity.DataTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PieChartDTO {

    private long id;
    private String title;
    private String infoIconUrl;
    private String description;
    private List<DataTable> dataTables;
}
