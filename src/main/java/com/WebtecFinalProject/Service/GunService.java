package com.WebtecFinalProject.Service;

import com.WebtecFinalProject.Model.Gun;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GunService {
    Gun createGun(Gun gun);
    List<Gun> getAllGuns();
    Page<Gun> getAllGunsPageable(int page, int size);
    void deleteGun(UUID id);
    Optional<Gun> findById(UUID id);
}
