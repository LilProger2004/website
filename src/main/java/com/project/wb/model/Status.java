package com.project.wb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Status {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    private String stus_name;
}
