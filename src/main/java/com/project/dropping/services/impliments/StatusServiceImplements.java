package com.project.dropping.services.impliments;

import com.project.dropping.model.Status;
import com.project.dropping.repository.StatusRepository;
import com.project.dropping.services.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StatusServiceImplements implements StatusService {

    final StatusRepository statusRepository;

    @Override
    public Status findById(Long id) {
        return statusRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }
}
