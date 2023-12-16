package com.WebtecFinalProject.Service;

import com.WebtecFinalProject.Model.Request;
import com.WebtecFinalProject.Model.Soldier;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RequestService {
    Request createRequest(Request request);
    public List<Request> getAllRequests();
    Page<Request> getAllRequestsPageable(int page, int size);
    public Request getRequestById(UUID id);
    void updateRequest(UUID id, Request updatedRequest);
    Optional<Request> findById(UUID id);
    void deleteReturn(UUID id);
}
