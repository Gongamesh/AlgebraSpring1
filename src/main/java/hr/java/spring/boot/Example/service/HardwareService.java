package hr.java.spring.boot.Example.service;

import hr.java.spring.boot.Example.dto.HardwareDTO;

import java.util.List;

public interface HardwareService {
    List<HardwareDTO> getAllHardware();
    List<HardwareDTO> getHardwareByCode(String hardwareCode);
}
