package com.project.dropping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class SaleStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sale_status;

    public void setId_sale_status(Long idSaleStatus) {
        this.id_sale_status = idSaleStatus;
    }

    public void setSaleStatus_name(String saleStatus_name) {
        this.saleStatus_name = saleStatus_name;
    }

    private String saleStatus_name;

    public SaleStatus() {
    }
}
