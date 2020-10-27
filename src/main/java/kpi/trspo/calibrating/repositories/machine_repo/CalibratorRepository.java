package kpi.trspo.calibrating.repositories.machine_repo;

import kpi.trspo.calibrating.entities.machines.Calibrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CalibratorRepository extends JpaRepository<Calibrator, UUID> {

}