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
@RequestMapping("/api/hardware")
@AllArgsConstructor
public class HardwareController {

    private HardwareService hardwareService;

    @GetMapping
    public List<HardwareDTO> getAllHardware() {
        return hardwareService.getAllHardware();
    }

    @GetMapping("/{hardwareCode}")
    public ResponseEntity<?> getHardwareByCode(@PathVariable String hardwareCode) {
        List<HardwareDTO> result = hardwareService.getHardwareByCode(hardwareCode);

        return result.isEmpty() ? ResponseEntity.badRequest().build() : ResponseEntity.ok(result);
    }

    @GetMapping("/id/{hardwareId}")
    public ResponseEntity<?> getHardwareById(@PathVariable Integer hardwareId) {
        Optional<HardwareDTO> optionalHardwareDTO = hardwareService.getHardwareById(hardwareId);

        if(optionalHardwareDTO.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalHardwareDTO.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/id/{hardwareId}")
    public ResponseEntity<?> deleteHardwareById(@PathVariable Integer hardwareId) {
        return hardwareService.deleteHardwareById(hardwareId) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<Integer>  saveNewHardware(@Valid @RequestBody HardwareDTO hardwareDTO) {
        Integer generatedId = hardwareService.saveNewHardware(hardwareDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(generatedId);
    }

    @PutMapping("/{hardwareCode}")
    public ResponseEntity<?> updateHardware(@Valid @RequestBody HardwareDTO hardwareDTO, @PathVariable Integer hardwareId) {
        if(hardwareService.hardwareByIdExists(hardwareId)) {
            hardwareService.updateHardware(hardwareDTO, hardwareId);
            return ResponseEntity.ok(hardwareDTO);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{hardwareCode}")
    public ResponseEntity<?> deleteHardwareByCode(@PathVariable String hardwareCode) {
        if (hardwareService.hardwareByCodeExists(hardwareCode)) {
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
