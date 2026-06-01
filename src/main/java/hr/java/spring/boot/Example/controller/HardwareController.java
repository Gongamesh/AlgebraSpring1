package hr.java.spring.boot.Example.controller;

import hr.java.spring.boot.Example.dto.HardwareDTO;
import hr.java.spring.boot.Example.service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
