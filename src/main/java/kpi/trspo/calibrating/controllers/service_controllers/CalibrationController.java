package kpi.trspo.calibrating.controllers.service_controllers;


import kpi.trspo.calibrating.dto.calibration.CalibrateCameraDTO;
import kpi.trspo.calibrating.entities.machines.Calibrator;
import kpi.trspo.calibrating.services.CalibrationService;
import kpi.trspo.calibrating.entities.camera.Camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/calibrate")
public final class CalibrationController {

    private final CalibrationService calibrationService;

    @Autowired
    public CalibrationController(CalibrationService calibrationService) {
        this.calibrationService = calibrationService;
    }

    @PostMapping
    public ResponseEntity<Camera> calibrate(@RequestBody CalibrateCameraDTO calibrateCameraDTO) throws Exception {
        Camera camera = calibrateCameraDTO.getCamera();
        UUID calibratorId = calibrateCameraDTO.getCalibratorId();
        Camera updated_camera = this.calibrationService.calibrateCamera(calibratorId, camera);
        return ResponseEntity.ok(updated_camera);
    }

}
