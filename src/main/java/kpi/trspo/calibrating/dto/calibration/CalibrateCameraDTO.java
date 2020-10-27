package kpi.trspo.calibrating.dto.calibration;

import kpi.trspo.calibrating.entities.camera.Camera;
import kpi.trspo.calibrating.entities.machines.Calibrator;
import lombok.Data;

import java.util.UUID;

@Data
public final class CalibrateCameraDTO {
    private UUID calibratorId;
    private Camera camera;
}
