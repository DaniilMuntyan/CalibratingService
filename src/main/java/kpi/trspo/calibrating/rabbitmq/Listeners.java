package kpi.trspo.calibrating.rabbitmq;

import kpi.trspo.calibrating.dto.calibration.CalibrateCameraDTO;
import kpi.trspo.calibrating.dto.machine_dto.MachineDTO;
import kpi.trspo.calibrating.entities.camera.Camera;
import kpi.trspo.calibrating.entities.machines.Calibrator;
import kpi.trspo.calibrating.rabbitmq.config.MessagingConfig;
import kpi.trspo.calibrating.services.CalibrationService;
import kpi.trspo.calibrating.services.model.MachineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class Listeners {

    private final RabbitTemplate template;

    private final MachineService machineService;

    private final CalibrationService calibrationService;

    @Autowired
    public Listeners(RabbitTemplate template, CalibrationService calibrationService, MachineService machineService) {
        this.template = template;
        this.calibrationService = calibrationService;
        this.machineService = machineService;
    }

    @RabbitListener(queues = MessagingConfig.CREATE_CALIBRATOR_QUEUE)
    public void createCalibrator(MachineDTO machineDTO) {
        Calibrator newCalibrator = new Calibrator(machineDTO.getName());
        this.machineService.save(newCalibrator);
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.RESPONSE_CALIBRATOR_ROUTING, newCalibrator);
    }

    @RabbitListener(queues = MessagingConfig.GET_ALL_CALIBRATORS_QUEUE)
    public void getAllCalibrators(String string) throws Exception {
        System.out.println("getAllCalibrators. " + string);
        List<Calibrator> calibrators = this.machineService.findAllCalibrators();
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.RESPONSE_GET_ALL_CALIBRATORS_ROUTING, calibrators);
    }

    @RabbitListener(queues = MessagingConfig.CALIBRATE_CAMERA_QUEUE)
    public void calibrateCamera(CalibrateCameraDTO calibrateCameraDTO) throws Exception {
        Camera camera = calibrateCameraDTO.getCamera();
        UUID calibratorId = calibrateCameraDTO.getCalibratorId();
        Camera updated_camera = this.calibrationService.calibrateCamera(calibratorId, camera);
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.RESPONSE_CALIBRATE_CAMERA_ROUTING, updated_camera);
    }

}
