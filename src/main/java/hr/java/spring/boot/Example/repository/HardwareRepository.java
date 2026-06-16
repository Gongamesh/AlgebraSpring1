package hr.java.spring.boot.Example.repository;

import hr.java.spring.boot.Example.domain.Hardware;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {
    List<Hardware> getAllHardware();
    List<Hardware> getHardwareByCode(String hardwareCode);
    Optional<Hardware> getHardwareById(Integer hardwareId);
    Integer saveNewHardware(Hardware hardware);
    Optional<Hardware> updateHardware(Hardware hardwareToUpdate, String hardwareCode);
    boolean hardwareByIdExists(String hradwareCode);
    boolean deleteHardwareByCode(String hardwareCode);
}
