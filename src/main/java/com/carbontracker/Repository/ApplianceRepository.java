package com.carbontracker.Repository;

import com.carbontracker.Model.Appliances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplianceRepository extends JpaRepository<Appliances, Long> {
}
