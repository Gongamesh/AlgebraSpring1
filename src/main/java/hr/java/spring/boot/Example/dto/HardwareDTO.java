package hr.java.spring.boot.Example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class HardwareDTO {
    private String hardwareName;
    private BigDecimal hardwarePrice;
    private int hardwareAvailable;
    private String categoryName;
}
