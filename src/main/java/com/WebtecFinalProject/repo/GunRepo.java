package com.WebtecFinalProject.repo;

import com.WebtecFinalProject.Model.Gun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GunRepo extends JpaRepository<Gun, UUID> {
}
