package hr.java.spring.boot.Example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class HardwareDTO {
    @NotBlank(message = "Hardware name cannot be blank")
    private String hardwareName;

    @NotNull(message = "Hardware price cannot be blank")
    @PositiveOrZero(message = "Hardware price must be positive")
    private BigDecimal hardwarePrice;

    @PositiveOrZero(message = "Hardware ammount must be positive")
    private int hardwareAvailable;

    @NotNull(message = "Hardware category id cannot be null")
    private Integer categoryId;
}
