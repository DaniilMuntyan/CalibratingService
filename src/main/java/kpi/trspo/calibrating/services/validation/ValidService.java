package kpi.trspo.calibrating.services.validation;

import kpi.trspo.calibrating.exception.InvalidRequestException;
import kpi.trspo.calibrating.exception.ResourceNotAllowedException;
import kpi.trspo.calibrating.exception.ResourceNotFoundException;
import kpi.trspo.calibrating.entities.camera.Camera;
import kpi.trspo.calibrating.entities.machines.Calibrator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class ValidService {

    //region checkObjectNotFound
    public void checkObjectNotFound(Camera camera, UUID id) throws ResourceNotFoundException {
        if (camera != null)
            return;

        throw new ResourceNotFoundException(String.format("Camera with id %s does not exist", id));
    }

    public void checkObjectNotFound(Calibrator calibrator, UUID id) throws ResourceNotFoundException {
        if (calibrator != null)
            return;

        throw new ResourceNotFoundException(String.format("Calibrate machine with id %s does not exist", id));
    }
    //endregion
}
