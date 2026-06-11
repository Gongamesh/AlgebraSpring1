package hr.java.spring.boot.Example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

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

    public static Category getCategoryFromName(String name) {
        return Arrays.stream(values())
                .filter(category -> category.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Category doesnt exist: " +name));
    }

    public static Category getCategoryFromId(Integer id) {
        for (Category category : values()) {
            if(category.getId().equals(id)) {
                return category;
            }
        }

        throw new IllegalArgumentException("Unknown category id: " +id);
    }
}
