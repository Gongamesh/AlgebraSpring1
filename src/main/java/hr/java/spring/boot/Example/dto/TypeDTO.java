package hr.java.spring.boot.Example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TypeDTO {
    @NotBlank(message = "Type name cannot be blank")
    private String typeName;
}
