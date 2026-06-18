/*package hr.java.spring.boot.Example.repository.impl;

import hr.java.spring.boot.Example.domain.Category;
import hr.java.spring.boot.Example.domain.Hardware;
import hr.java.spring.boot.Example.domain.Type;
import hr.java.spring.boot.Example.repository.HardwareRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class HardwareRepositoryImpl implements HardwareRepository {

    private static List<Hardware> hardwareList;

    static {
        hardwareList = new ArrayList<>();

        Hardware firstHardware = new Hardware(1, "AMD Ryzen", "A1", new BigDecimal(180), 5, new Type());
        Hardware secondHardware = new Hardware(2, "NVIDIA GeForce", "B2", new BigDecimal(350), 10, new Type());
        Hardware thirdHardware = new Hardware(3, "Corsair Vengeance", "C3", new BigDecimal(60), 50, new Type());
        Hardware fourthHardware = new Hardware(4, "MSI B550", "D4", new BigDecimal(130), 7, new Type());
        Hardware fifthHardware = new Hardware(5, "Samsung 970 EVO", "E5", new BigDecimal(90), 20, new Type());
        Hardware sixthHardware = new Hardware(6, "Corsair CX650", "F6", new BigDecimal(70), 28, new Type());

        hardwareList.add(firstHardware);
        hardwareList.add(secondHardware);
        hardwareList.add(thirdHardware);
        hardwareList.add(fourthHardware);
        hardwareList.add(fifthHardware);
        hardwareList.add(sixthHardware);
    }

    @Override
    public List<Hardware> getAllHardware() {
        return hardwareList;
    }

    @Override
    public List<Hardware> getHardwareByCode(String hardwareCode) {
        return hardwareList.stream()
                .filter(h -> h.getCode().contains(hardwareCode))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Hardware> getHardwareById(Integer hardwareId) {
        return Optional.empty();
    }

    @Override
    public boolean hardwareByIdExists(Integer hardwareId) {
        return false;
    }

    @Override
    public boolean deleteHardwareById(Integer hardwareId) {
        return false;
    }

    @Override
    public Integer saveNewHardware(Hardware hardware) {
        Integer generatedId = hardwareList.size() + 1;
        hardware.setCode(hardwareList.size() + 1 + "");
        hardwareList.add(hardware);
        return generatedId;
    }


    @Override
    public Optional<Hardware> updateHardware(Hardware hardwareToUpdate, Integer hardwareId) {
        Optional<Hardware> storedHardwareOptional = hardwareList.stream().filter(h -> h.getId().equals(hardwareId)).findFirst();
        if (storedHardwareOptional.isPresent()) {
            Hardware storedHardware = storedHardwareOptional.get();
            storedHardware.setName(hardwareToUpdate.getName());
            storedHardware.setAvailable(hardwareToUpdate.getAvailable());
            //storedHardware.setPrice(hardwareToUpdate.getPrice());
            //storedHardware.setCategory(hardwareToUpdate.getCategory());

            return Optional.of(storedHardware);
        }

        return Optional.empty();
    }

    @Override
    public boolean hardwareByCodeExists(String hardwareCode) {
        return hardwareList.stream().filter(h -> h.getCode().equalsIgnoreCase(hardwareCode)).findFirst().isPresent();
    }

    @Override
    public boolean deleteHardwareByCode(String hardwareCode) {
        return hardwareList.removeIf(hardware -> hardware.getCode().equalsIgnoreCase(hardwareCode));
    }
} */
