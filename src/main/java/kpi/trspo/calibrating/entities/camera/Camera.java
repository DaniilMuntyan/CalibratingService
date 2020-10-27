package kpi.trspo.calibrating.entities.camera;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "cameras")

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public final class Camera {
    @Id
    private UUID camera_id;

    private String innerInfo;
    private Boolean isPacked;
    private Boolean isFirmware;
    private Boolean isWipedClean;
    private Boolean isRejected;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "back_id")
    @NonNull
    private CameraBack cameraBack;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "body_id")
    @NonNull
    private CameraBody cameraBody;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "lens_id")
    @NonNull
    private CameraLens cameraLens;
}
