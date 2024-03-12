package com.project.dropping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Category() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    private String category_name;

    public Category(Long id, String category_name) {
        this.id = id;
        this.category_name = category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
