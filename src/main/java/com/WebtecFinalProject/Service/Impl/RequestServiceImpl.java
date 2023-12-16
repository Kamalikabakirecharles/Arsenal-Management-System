package com.WebtecFinalProject.Service.Impl;

import com.WebtecFinalProject.Model.Request;
import com.WebtecFinalProject.Service.RequestService;
import com.WebtecFinalProject.repo.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RequestServiceImpl implements RequestService {
   @Autowired
    RequestRepo requestRepo;

    @Override
    public Request createRequest(Request request) {
        return requestRepo.save(request);
    }

    @Override
    public List<Request> getAllRequests(){ return requestRepo.findAll();}

    @Override
    public Page<Request> getAllRequestsPageable(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return requestRepo.findAll(pageable);
    }

    @Override
    public Request getRequestById(UUID id) {
        return requestRepo.findById(id).orElse(null);
    }

    @Override
    public Optional<Request> findById(UUID id){return requestRepo.findById(id);}

    @Override
    public void deleteReturn(UUID id) {
        requestRepo.deleteById(id);
    }

    @Override
    public void updateRequest(UUID id, Request updatedRequest) {
        Optional<Request> existingRequest = requestRepo.findById(id);
        if (existingRequest.isPresent()) {
            Request requestToUpdate = existingRequest.get();
            // Update fields based on your requirements
            requestToUpdate.setGun(updatedRequest.getGun());
            requestToUpdate.setRequestdate(updatedRequest.getRequestdate());
            requestToUpdate.setSoldier(updatedRequest.getSoldier());
            // Save the updated request
            requestRepo.save(requestToUpdate);
        }
    }
}
