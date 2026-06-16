package hr.java.spring.boot.Example.service.impl;

import hr.java.spring.boot.Example.domain.Category;
import hr.java.spring.boot.Example.domain.Hardware;
import hr.java.spring.boot.Example.dto.HardwareDTO;
import hr.java.spring.boot.Example.repository.HardwareRepository;
import hr.java.spring.boot.Example.service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<HardwareDTO> getHardwareById(Integer hardwareId) {
        Optional<Hardware> optionalHardware = hardwareRepository.getHardwareById(hardwareId);

        if (optionalHardware.isPresent()) {
            return Optional.of(convertHardwareToHardwareDTO(optionalHardware.get()));
        }

        return Optional.empty();
    }

    @Override
    public Integer saveNewHardware(HardwareDTO hardware) {
        return hardwareRepository.saveNewHardware(convertHardwareDTOToHardware(hardware));
    }

    @Override
    public Optional<HardwareDTO> updateHardware(HardwareDTO hardwareToUpdate, String hardwareCode) {
        Optional<Hardware> updatedHardwareOptional =
                hardwareRepository.updateHardware(convertHardwareDTOToHardware(hardwareToUpdate), hardwareCode);

        if (updatedHardwareOptional.isPresent()) {
            return Optional.of(convertHardwareToHardwareDTO(updatedHardwareOptional.get()));
        }

        return Optional.empty();
    }

    @Override
    public boolean hardwareByIdExists(String hardwareCode) {
        return hardwareRepository.hardwareByIdExists(hardwareCode);
    }

    @Override
    public boolean deleteHardwareByCode(String hardwareCode) {
        return hardwareRepository.deleteHardwareByCode(hardwareCode);
    }

    private HardwareDTO convertHardwareToHardwareDTO(Hardware hardware) {
        return new HardwareDTO(hardware.getName(),
                hardware.getPrice(),
                hardware.getAvailable(),
                hardware.getCategory().getName());
    }

    private Hardware convertHardwareDTOToHardware(HardwareDTO hardware) {
        Hardware newHardware = new Hardware();
        newHardware.setName(hardware.getHardwareName());
        newHardware.setPrice(hardware.getHardwarePrice());
        newHardware.setAvailable(hardware.getHardwareAvailable());
        newHardware.setCategory(Category.getCategoryFromName(hardware.getCategoryName()));
        return newHardware;
    }

}
