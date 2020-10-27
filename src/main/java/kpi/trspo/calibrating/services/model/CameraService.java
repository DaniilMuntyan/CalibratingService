package kpi.trspo.calibrating.services.model;

import kpi.trspo.calibrating.entities.camera.Camera;
import kpi.trspo.calibrating.repositories.camera_repo.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public final class CameraService {

    private final CameraRepository cameraRepository;

    @Autowired
    public CameraService(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    public Camera findCamera(UUID camera) {
        if (camera == null)
            return null;

        return this.cameraRepository.findById(camera).orElse(null);
    }

    public List<Camera> findAllCameras() {
        return this.cameraRepository.findAll();
    }

    public Camera save(Camera camera) {
        return this.cameraRepository.save(camera);
    }
}
