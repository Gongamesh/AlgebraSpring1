package hr.java.spring.boot.Example.service.impl;

import hr.java.spring.boot.Example.domain.Hardware;
import hr.java.spring.boot.Example.dto.HardwareDTO;
import hr.java.spring.boot.Example.repository.HardwareRepository;
import hr.java.spring.boot.Example.service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements HardwareService {

    private HardwareRepository hardwareRepository;

    @Override
    public List<HardwareDTO> getAllHardware() {
        return hardwareRepository.getAllHardware().stream()
                .map(this::convertHardwareToHardwareDTO)
                .toList();
    }

    @Override
    public List<HardwareDTO> getHardwareByCode(String hardwareCode) {
        return hardwareRepository.getHardwareByCode(hardwareCode).stream()
                .map(this::convertHardwareToHardwareDTO)
                .toList();
    }

    private HardwareDTO convertHardwareToHardwareDTO(Hardware hardware) {
        return new HardwareDTO(hardware.getName(),
                hardware.getPrice(),
                hardware.getAvailable(),
                hardware.getCategory().getName());
    }
}
