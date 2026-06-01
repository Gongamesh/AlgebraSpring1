package hr.java.spring.boot.Example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Hardware {
    private String name;
    private String code;
    private BigDecimal price;
    private int available;
    private Category category;
}
