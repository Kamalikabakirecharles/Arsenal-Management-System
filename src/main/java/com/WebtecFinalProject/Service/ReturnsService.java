package com.WebtecFinalProject.Service;

import com.WebtecFinalProject.Model.Returns;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

public interface ReturnsService {
    Returns createReturns(Returns returns);
    public List<Returns> getAllReturns();
    Page<Returns> getAllReturnsPageable(int page, int size);
    void deleteReturns(UUID id);
    Optional<Returns> findById(UUID id);


}
