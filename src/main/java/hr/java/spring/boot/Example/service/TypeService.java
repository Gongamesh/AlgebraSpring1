package hr.java.spring.boot.Example.service;


import hr.java.spring.boot.Example.dto.TypeDTO;

import java.util.List;
import java.util.Optional;

public interface TypeService {
    List<TypeDTO> getAllType();
    List<TypeDTO> getTypeByName(String typeName);
    Optional<TypeDTO> getTypeById(Integer typeId);
    boolean typeByIdExists(Integer typeId);
    boolean deleteTypeById(Integer typeId);
    Integer saveNewType(TypeDTO type);
    Optional<TypeDTO> updateType(TypeDTO typeToUpdate, Integer typeId);
}
