package com.carbonTracker.Repository;

import com.carbonTracker.Model.Appliances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplianceRepository extends JpaRepository<Appliances, Long> {
}
