package com.andersen.piechart.entity;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Data
@Entity
@Table(name = "pie_charts")
public class PieChart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pc_id")
    private long id;

    @Column(name = "pc_title")
    private String title;

    @Column(name = "pc_url")
    private String infoIconUrl;

    @Column(name = "pc_description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_id")
    private List<DataTable> dataTables;
}
