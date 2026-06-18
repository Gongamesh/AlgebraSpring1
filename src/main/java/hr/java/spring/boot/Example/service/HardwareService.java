package hr.java.spring.boot.Example.service;

import hr.java.spring.boot.Example.domain.Hardware;
import hr.java.spring.boot.Example.dto.HardwareDTO;

import java.util.List;
import java.util.Optional;

public interface HardwareService {
    List<HardwareDTO> getAllHardware();
    List<HardwareDTO> getHardwareByCode(String hardwareCode);
    Optional<HardwareDTO> getHardwareById(Integer hardwareId);
    boolean hardwareByIdExists(Integer hardwareId);
    boolean deleteHardwareById(Integer hardwareId);
    Integer saveNewHardware(HardwareDTO hardware);
    Optional<HardwareDTO> updateHardware(HardwareDTO hardwareToUpdate, Integer hardwareId);
    boolean hardwareByCodeExists(String hardwareCode);
    boolean deleteHardwareByCode(String hardwareCode);
}
