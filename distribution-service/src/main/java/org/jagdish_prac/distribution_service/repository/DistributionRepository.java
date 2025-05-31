package org.jagdish_prac.distribution_service.repository;

import org.jagdish_prac.distribution_service.entity.Distribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionRepository extends JpaRepository<Distribution, Long> {
}
