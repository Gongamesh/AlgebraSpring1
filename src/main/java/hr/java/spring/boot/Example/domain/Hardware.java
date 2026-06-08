package hr.java.spring.boot.Example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hardware {
    private String name;
    private String code;
    private BigDecimal price;
    private int available;
    private Category category;
}
