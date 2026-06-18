package hr.java.spring.boot.Example.service.impl;

import hr.java.spring.boot.Example.domain.Category;
import hr.java.spring.boot.Example.domain.Hardware;
import hr.java.spring.boot.Example.domain.Type;
import hr.java.spring.boot.Example.dto.HardwareDTO;
import hr.java.spring.boot.Example.repository.HardwareRepository;
import hr.java.spring.boot.Example.repository.TypeRepository;
import hr.java.spring.boot.Example.service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements HardwareService {

    private HardwareRepository hardwareRepository;
    private TypeRepository typeRepository;

    @Override
    public List<HardwareDTO> getAllHardware() {
        return hardwareRepository.findAll()
                .stream()
                .map(this::convertHardwareToHardwareDTO)
                .toList();
    }

    @Override
    public List<HardwareDTO> getHardwareByCode(String hardwareCode) {
        return hardwareRepository.findByCodeContaining(hardwareCode)
                .stream()
                .map(this::convertHardwareToHardwareDTO)
                .toList();
    }

    @Override
    public Optional<HardwareDTO> getHardwareById(Integer hardwareId) {
        Optional<Hardware> optionalHardware = hardwareRepository.findById(hardwareId);

        if (optionalHardware.isPresent()) {
            return Optional.of(convertHardwareToHardwareDTO(optionalHardware.get()));
        }

        return Optional.empty();
    }

    @Override
    public boolean hardwareByIdExists(Integer hardwareId) {
        return hardwareRepository.existsById(hardwareId);
    }

    @Override
    public boolean deleteHardwareById(Integer hardwareId) {
        if(hardwareByIdExists(hardwareId)) {
            hardwareRepository.deleteById(hardwareId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer saveNewHardware(HardwareDTO hardware) {
        return hardwareRepository.save(convertHardwareDTOToHardware(hardware)).getId();
    }

    @Override
    public Optional<HardwareDTO> updateHardware(HardwareDTO hardwareToUpdate, Integer hardwareId) {
        return hardwareRepository.findById(hardwareId)
                .map(existing -> {
                    existing.setName(hardwareToUpdate.getHardwareName());
                    existing.setPrice(hardwareToUpdate.getHardwarePrice());
                    existing.setAvailable(hardwareToUpdate.getHardwareAvailable());
                    existing.setType(typeRepository.findById(hardwareToUpdate.getCategoryId())
                            .orElseThrow(() -> new RuntimeException("Type not found")));

                    return convertHardwareToHardwareDTO(hardwareRepository.save(existing));
                });
    }

    @Override
    public boolean hardwareByCodeExists(String hardwareCode) {
        return hardwareRepository.existsByCode(hardwareCode);
    }

    @Override
    public boolean deleteHardwareByCode(String hardwareCode) {
        if(hardwareRepository.existsByCode(hardwareCode)) {
            hardwareRepository.deleteByCode(hardwareCode);
            return true;
        } else {
            return false;
        }
    }

    private HardwareDTO convertHardwareToHardwareDTO(Hardware hardware) {
        return new HardwareDTO(hardware.getName(),
                hardware.getPrice(),
                hardware.getAvailable(),
                hardware.getType().getId());
    }

    private Hardware convertHardwareDTOToHardware(HardwareDTO hardware) {
        Hardware newHardware = new Hardware();
        newHardware.setName(hardware.getHardwareName());
        newHardware.setPrice(hardware.getHardwarePrice());
        newHardware.setAvailable(hardware.getHardwareAvailable());
        Type type = typeRepository.findById(hardware.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Type not found"));

        newHardware.setType(type);

        return newHardware;
    }

}
