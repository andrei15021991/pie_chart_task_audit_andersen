package com.andersen.piechart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "data_table")
public class DataTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dt_id")
    private long id;

    @NotBlank
    @Length(min = 1, max = 30, message = "length should be from 1 to 30")
    @Column(name = "dt_item")
    private String item;

    @DecimalMin(value = "0.00", message = "min value is 0.00")
    @DecimalMax(value = "9999.99", message = "max value is 9999.99")
    @Column(name = "dt_value")
    private Double value;

}
