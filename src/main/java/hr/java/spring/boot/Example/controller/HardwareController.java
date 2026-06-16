package hr.java.spring.boot.Example.controller;

import hr.java.spring.boot.Example.dto.HardwareDTO;
import hr.java.spring.boot.Example.service.HardwareService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hardware")
@AllArgsConstructor
public class HardwareController {

    private HardwareService hardwareService;

    @GetMapping
    public List<HardwareDTO> getAllHardware() {
        return hardwareService.getAllHardware();
    }

    @GetMapping("/{hardwareCode}")
    public List<HardwareDTO> getHardwareByCode(@PathVariable String hardwareCode) {
        return hardwareService.getHardwareByCode(hardwareCode);
    }

    @GetMapping("/id/{hardwareId}")
    public ResponseEntity<?> getHardwareById(@PathVariable Integer hardwareId) {
        Optional<HardwareDTO> optionalHardwareDTO = hardwareService.getHardwareById(hardwareId);

        if(optionalHardwareDTO.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalHardwareDTO.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<Integer>  saveNewHardware(@Valid @RequestBody HardwareDTO hardwareDTO) {
        Integer generatedId = hardwareService.saveNewHardware(hardwareDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(generatedId);
    }

    @PutMapping("/{hardwareCode}")
    public ResponseEntity<?> updateHardware(@Valid @RequestBody HardwareDTO hardwareDTO, @PathVariable String hardwareCode) {
        if(hardwareService.hardwareByIdExists(hardwareCode)) {
            hardwareService.updateHardware(hardwareDTO, hardwareCode);
            return ResponseEntity.ok(hardwareDTO);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{hardwareCode}")
    public ResponseEntity<?> deleteHardwareByCode(@PathVariable String hardwareCode) {
        if (hardwareService.hardwareByIdExists(hardwareCode)) {
            boolean result = hardwareService.deleteHardwareByCode(hardwareCode);

            if (result) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.noContent().build();
            }
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
