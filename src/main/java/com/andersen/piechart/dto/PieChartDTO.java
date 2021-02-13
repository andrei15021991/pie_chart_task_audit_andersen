package com.andersen.piechart.dto;

import com.andersen.piechart.entity.DataTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PieChartDTO {

    private long id;

    @NotBlank(message = "pie-chart should have a title")
    @Length(min = 1, max = 70, message = "length should be from 1 to 70")
    private String title;

    @NotBlank
    @Length(min = 1, max = 2048, message = "length should be from 1 to 2048")
    private String infoIconUrl;

    @NotBlank
    @Length(min = 1, max = 250, message = "length should be from 1 to 250")
    private String description;

    @Size(min = 1, max = 12, message = "size should be from 1 to 12")
    @Valid
    private List<DataTable> dataTables;
}
