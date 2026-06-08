package hr.java.spring.boot.Example.repository.impl;

import hr.java.spring.boot.Example.domain.Category;
import hr.java.spring.boot.Example.domain.Hardware;
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

        Hardware firstHardware = new Hardware("AMD Ryzen", "A1", new BigDecimal(180), 5, Category.CPU);
        Hardware secondHardware = new Hardware("NVIDIA GeForce", "B2", new BigDecimal(350), 10, Category.GPU);
        Hardware thirdHardware = new Hardware("Corsair Vengeance", "C3", new BigDecimal(60), 50, Category.RAM);
        Hardware fourthHardware = new Hardware("MSI B550", "D4", new BigDecimal(130), 7, Category.MBO);
        Hardware fifthHardware = new Hardware("Samsung 970 EVO", "E5", new BigDecimal(90), 20, Category.STORAGE);
        Hardware sixthHardware = new Hardware("Corsair CX650", "F6", new BigDecimal(70), 28, Category.OTHER);

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
    public Integer saveNewHardware(Hardware hardware) {
        Integer generatedId = hardwareList.size() + 1;
        hardware.setCode(hardwareList.size() + 1 + "");
        hardwareList.add(hardware);
        return generatedId;
    }

    @Override
    public Optional<Hardware> updateHardware(Hardware hardwareToUpdate, String hardwareCode) {
        Optional<Hardware> storedHardwareOptional = hardwareList.stream().filter(h -> h.getCode().equalsIgnoreCase(hardwareCode)).findFirst();
        if (storedHardwareOptional.isPresent()) {
            Hardware storedHardware = storedHardwareOptional.get();
            storedHardware.setName(hardwareToUpdate.getName());
            storedHardware.setAvailable(hardwareToUpdate.getAvailable());
            storedHardware.setPrice(hardwareToUpdate.getPrice());
            storedHardware.setCode(hardwareToUpdate.getCode());

            return Optional.of(storedHardware);
        }

        return Optional.empty();
    }

    @Override
    public boolean hardwareByIdExists(String hardwareCode) {
        return hardwareList.stream().filter(h -> h.getCode().equalsIgnoreCase(hardwareCode)).findFirst().isPresent();
    }
}
