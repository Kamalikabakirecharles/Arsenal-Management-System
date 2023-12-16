package com.WebtecFinalProject.repo;

import com.WebtecFinalProject.Model.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SoldierRepo extends JpaRepository<Soldier, UUID> {

    Soldier findSoldierByUsernameAndPassword(String username, String password);

    Soldier findSoldierByMilitaryNumber(Integer MilitaryNumber);

}
