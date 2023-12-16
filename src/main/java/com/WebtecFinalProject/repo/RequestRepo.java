package com.WebtecFinalProject.repo;

import com.WebtecFinalProject.Model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequestRepo extends JpaRepository<Request, UUID> {
}
