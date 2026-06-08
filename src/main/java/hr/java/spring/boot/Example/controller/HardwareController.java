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

    @PostMapping("/new")
    public ResponseEntity<Integer>  saveNewHardware(@Valid @RequestBody HardwareDTO hardwareDTO) {
        Integer generatedId = hardwareService.saveNewHardware(hardwareDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(generatedId);
    }
}
