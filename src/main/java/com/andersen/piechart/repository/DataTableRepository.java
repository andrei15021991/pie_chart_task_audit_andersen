package com.andersen.piechart.repository;

import com.andersen.piechart.entity.DataTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataTableRepository extends JpaRepository<DataTable, Long> {
}
