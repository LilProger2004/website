package com.project.dropping.services;

import com.project.dropping.model.Status;

import java.util.List;


public interface StatusService {
    Status findById(Long id);
    List<Status> findAll();
}
