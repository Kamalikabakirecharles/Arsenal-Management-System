package com.WebtecFinalProject.Service.Impl;

import com.WebtecFinalProject.Model.Gun;
import com.WebtecFinalProject.Service.GunService;
import com.WebtecFinalProject.repo.GunRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GunServiceImpl implements GunService {
    @Autowired
    GunRepo gunRepo;
    @Override
    public Gun createGun(Gun gun) {
        return gunRepo.save(gun);
    }
    @Override
    public List<Gun> getAllGuns() {
        return gunRepo.findAll();
    }

    @Override
    public Page<Gun> getAllGunsPageable(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return gunRepo.findAll(pageable);
    }

    @Override
    public void deleteGun(UUID id) {
        gunRepo.deleteById(id);
    }

    @Override
    public Optional<Gun> findById(UUID id) {
        return gunRepo.findById(id);
    }
}
