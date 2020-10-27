package kpi.trspo.calibrating.entities.machines;

import kpi.trspo.calibrating.entities.camera.Camera;
import kpi.trspo.calibrating.entities.camera.CameraBack;
import lombok.*;

import javax.persistence.*;
import java.util.Random;
import java.util.UUID;

@Entity
@DiscriminatorValue("CALIBRATOR")

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public final class Calibrator {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    @NonNull
    private String name;

    public void checkMatrix(CameraBack cameraBack) {
        Random rnd = new Random();
        Boolean matrixCheck = rnd.nextInt(10) != 0; // Probability of defect: 1/10
        cameraBack.setMatrixCheck(matrixCheck);
    }

    public void innerCharacteristics(Camera camera) {
        Random rand = new Random();

        Double lensAngleOfView = 10 + (180 - 10) * rand.nextDouble();
        Double lensSpeed = 0 + 11 * rand.nextDouble();
        Double depthOfField = 2 + 18 * rand.nextDouble();

        String colorInfo = "Lens angle of view: " + lensAngleOfView.toString() + "\nLens speed: " +
                lensSpeed.toString() + "\nDepth of field: " + depthOfField.toString();

        camera.setInnerInfo(colorInfo);
    }
}
