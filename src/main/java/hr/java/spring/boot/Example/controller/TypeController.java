package hr.java.spring.boot.Example.controller;

import hr.java.spring.boot.Example.dto.TypeDTO;
import hr.java.spring.boot.Example.service.TypeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/type")
@AllArgsConstructor
public class TypeController {

    private TypeService typeService;

    @GetMapping
    public ResponseEntity<?> getAllType() {
        List<TypeDTO> result = typeService.getAllType();

        return result.isEmpty() ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build()
                : ResponseEntity.ok(result);
    }

    @GetMapping("/name/{typeName}")
    public ResponseEntity<?> getTypeByName(@PathVariable String typeName) {
        List<TypeDTO> result = typeService.getTypeByName(typeName);

        return result.isEmpty() ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build()
                : ResponseEntity.ok(result);
    }

    @GetMapping("/{typeId}")
    public ResponseEntity<?> getTypeById(@PathVariable Integer typeId) {
        Optional<TypeDTO> result = typeService.getTypeById(typeId);

        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{typeId}")
    public ResponseEntity<?> deleteTypeById(@PathVariable Integer typeId) {
        return typeService.deleteTypeById(typeId) ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveNewType(@Valid @RequestBody TypeDTO typeDTO) {
        Integer generatedId = typeService.saveNewType(typeDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(generatedId);
    }

    @PutMapping("/{typeId}")
    public ResponseEntity<?> updateType(@Valid @RequestBody TypeDTO typeDTO, @PathVariable Integer typeId) {
        if(typeService.typeByIdExists(typeId)) {
            Optional<TypeDTO> result = typeService.updateType(typeDTO, typeId);
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
