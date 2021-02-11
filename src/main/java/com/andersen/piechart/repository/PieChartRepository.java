package com.andersen.piechart.repository;

import com.andersen.piechart.entity.PieChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieChartRepository extends JpaRepository<PieChart, Long> {
}
