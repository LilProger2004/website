package com.project.dropping.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sale_status")
public class SaleStatus {
    @Id
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "sale_status_name", nullable = false)
    String saleStatusName;
}
