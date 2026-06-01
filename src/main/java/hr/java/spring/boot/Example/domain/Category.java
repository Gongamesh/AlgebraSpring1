package hr.java.spring.boot.Example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {

    CPU(1, "Processor"),
    GPU(2, "Graphics Card"),
    MBO(3, "Mbo"),
    RAM(4, "Memory"),
    STORAGE(5, "HDD & SSD"),
    OTHER(6, "Other");

    private final Integer id;
    private final String name;
}
