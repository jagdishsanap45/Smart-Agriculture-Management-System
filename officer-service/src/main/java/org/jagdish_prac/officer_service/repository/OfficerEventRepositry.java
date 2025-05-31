package org.jagdish_prac.officer_service.repository;


import org.jagdish_prac.officer_service.entity.OfficerEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficerEventRepositry extends JpaRepository<OfficerEvent, Long> {
}
