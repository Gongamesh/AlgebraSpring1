package hr.java.spring.boot.Example.repository;

import hr.java.spring.boot.Example.domain.Hardware;

import java.util.List;

public interface HardwareRepository {
    List<Hardware> getAllHardware();
    List<Hardware> getHardwareByCode(String hardwareCode);
}
