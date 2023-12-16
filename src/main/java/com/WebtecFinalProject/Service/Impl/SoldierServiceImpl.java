package com.WebtecFinalProject.Service.Impl;

import com.WebtecFinalProject.Model.Soldier;
import com.WebtecFinalProject.Service.SoldierService;
import com.WebtecFinalProject.repo.SoldierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SoldierServiceImpl implements SoldierService {
    @Autowired
    SoldierRepo soldierRepo;

    @Override
    public Soldier createSoldier(Soldier soldier) {
        return soldierRepo.save(soldier);
    }


    @Override
    public List<Soldier> getAllSoldiers() {
            return soldierRepo.findAll();
        }

    @Override
    @Cacheable(value = "allSoldiersCache", key = "{#page, #size}")
    public Page<Soldier> getAllSoldiersPageable(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return soldierRepo.findAll(pageable);
    }

    @Override
    public Soldier loginSoldier(Soldier soldier) {
        return soldierRepo.findSoldierByUsernameAndPassword(soldier.getUsername(), soldier.getPassword());
    }

    @Override
    public void deleteSoldier(UUID id) {
        soldierRepo.deleteById(id);
    }

    @Override
    public Optional<Soldier> findById(UUID id) {
        return soldierRepo.findById(id);
    }

    @Override
    public Soldier findSoldierByMilitaryNumber(int militaryNumber) {
        return soldierRepo.findSoldierByMilitaryNumber(militaryNumber);
    }


}
