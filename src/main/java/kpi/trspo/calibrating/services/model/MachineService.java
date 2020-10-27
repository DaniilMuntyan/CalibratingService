package kpi.trspo.calibrating.services.model;

import kpi.trspo.calibrating.entities.machines.Calibrator;
import kpi.trspo.calibrating.repositories.machine_repo.CalibratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public final class MachineService {

    private final CalibratorRepository calibratorRepository;

    @Autowired
    public MachineService(CalibratorRepository calibratorRepository) {
        this.calibratorRepository = calibratorRepository;
    }

    public Calibrator findCalibrator(UUID calibratorId) {
        if (calibratorId == null)
            return null;

        return this.calibratorRepository.findById(calibratorId).orElse(null);
    }
    public Calibrator save(Calibrator calibrator) {
        return this.calibratorRepository.save(calibrator);
    }

    public List<Calibrator> findAllCalibrators() {
        return this.calibratorRepository.findAll();
    }

}
