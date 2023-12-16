package com.WebtecFinalProject.Service;

import com.WebtecFinalProject.Model.Soldier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SoldierService {
    Soldier createSoldier(Soldier soldier);

    public List<Soldier> getAllSoldiers();

    Page<Soldier> getAllSoldiersPageable(int page, int size);

    Soldier loginSoldier(Soldier soldier);

    void deleteSoldier(UUID id);

    Optional<Soldier> findById(UUID id);
    Soldier findSoldierByMilitaryNumber(int militaryNumber);


}
