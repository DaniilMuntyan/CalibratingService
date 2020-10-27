package kpi.trspo.calibrating.services;

import kpi.trspo.calibrating.entities.camera.Camera;
import kpi.trspo.calibrating.entities.machines.Calibrator;
import kpi.trspo.calibrating.services.model.CameraService;
import kpi.trspo.calibrating.services.model.MachineService;
import kpi.trspo.calibrating.services.validation.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.UUID;

@Service
public final class CalibrationService {

    private final CameraService cameraService;

    private final MachineService machineService;

    private final ValidService validService;

    @Autowired
    public CalibrationService(CameraService cameraService, MachineService machineService, ValidService validService) {
        this.cameraService = cameraService;
        this.machineService = machineService;
        this.validService = validService;
    }

    public Camera calibrateCamera(UUID calibratorId, Camera camera) throws Exception {
        Calibrator calibrator = this.getCalibrator(calibratorId);

        calibrator.checkMatrix(camera.getCameraBack());

        calibrator.innerCharacteristics(camera);

        return this.cameraService.save(camera);
    }

    private Calibrator getCalibrator(UUID calibratorId) throws Exception
    {
        Calibrator calibrator = this.machineService.findCalibrator(calibratorId);

        this.validService.checkObjectNotFound(calibrator, calibratorId);
        return calibrator;
    }
}
