package com.WebtecFinalProject.Service.Impl;

import com.WebtecFinalProject.Model.Returns;
import com.WebtecFinalProject.Service.ReturnsService;
import com.WebtecFinalProject.repo.ReturnsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReturnsServiceImpl implements ReturnsService {
    @Autowired
    ReturnsRepo returnsRepo;
    @Override
    public Returns createReturns(Returns returns) {
        return returnsRepo.save(returns);
    }

    @Override
    public List<Returns> getAllReturns() {
        return returnsRepo.findAll();
    }

    @Override
    public Page<Returns> getAllReturnsPageable(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return returnsRepo.findAll(pageable);
    }

    @Override
    public void deleteReturns(UUID id) {
        returnsRepo.deleteById(id);
    }

    @Override
    public Optional<Returns> findById(UUID id) {
        return returnsRepo.findById(id);
    }
}
