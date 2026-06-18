package hr.java.spring.boot.Example.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hardware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String code;
    private BigDecimal price;
    private Integer available;

    @ManyToOne
    @JoinColumn(name = "typeFk")
    private Type type;
}
