package com.project.dropping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sale;

    public void setId_sale(Long id_sale) {
        this.id_sale = id_sale;
    }

    private Long buyer_id;
    private Long product_id;
    private Long salesman_id;
    private Long id_sale_status;

    public void setId_sale_status(Long id_sale_status) {
        this.id_sale_status = id_sale_status;
    }

    public void setBuyer_id(Long buyer_id) {
        this.buyer_id = buyer_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public void setSalesman_id(Long salesman_id) {
        this.salesman_id = salesman_id;
    }

    public Sales() {
    }
}
