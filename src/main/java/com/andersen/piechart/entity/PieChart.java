package com.andersen.piechart.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "pie_charts")
public class PieChart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pc_id")
    private long id;

    @NotBlank(message = "pie-chart should have a title")
    @Length(min = 1, max = 70, message = "length should be from 1 to 70")
    @Column(name = "pc_title")
    private String title;

    @NotBlank
    @Length(min = 1, max = 2048, message = "length should be from 1 to 2048")
    @Column(name = "pc_url")
    private String infoIconUrl;

    @NotBlank
    @Length(min = 1, max = 250, message = "length should be from 1 to 250")
    @Column(name = "pc_description")
    private String description;

    @Size(min = 1, max = 12, message = "size should be from 1 to 12")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_id")
    private List<DataTable> dataTables;
}
