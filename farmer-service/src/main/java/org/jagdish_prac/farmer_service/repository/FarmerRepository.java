package org.jagdish_prac.farmer_service.repository;

import org.jagdish_prac.farmer_service.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {
}
