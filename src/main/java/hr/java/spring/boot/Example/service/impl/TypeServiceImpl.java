package hr.java.spring.boot.Example.service.impl;

import hr.java.spring.boot.Example.domain.Type;
import hr.java.spring.boot.Example.dto.TypeDTO;
import hr.java.spring.boot.Example.repository.TypeRepository;
import hr.java.spring.boot.Example.service.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TypeServiceImpl implements TypeService {

    private TypeRepository typeRepository;

    @Override
    public List<TypeDTO> getAllType() {
        return typeRepository.findAll()
                .stream()
                .map(this::convertTypeToTypeDTO)
                .toList();
    }

    @Override
    public List<TypeDTO> getTypeByName(String typeName) {
        return typeRepository.findByNameContaining(typeName)
                .stream()
                .map(this::convertTypeToTypeDTO)
                .toList();
    }

    @Override
    public Optional<TypeDTO> getTypeById(Integer typeId) {
        Optional<Type> optionalType = typeRepository.findById(typeId);

        if (optionalType.isPresent()) {
            return Optional.of(convertTypeToTypeDTO(optionalType.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean typeByIdExists(Integer typeId) {
        return typeRepository.existsById(typeId);
    }

    @Override
    public boolean deleteTypeById(Integer typeId) {
        if (typeRepository.existsById(typeId)) {
            typeRepository.deleteById(typeId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer saveNewType(TypeDTO type) {
        return typeRepository.save(convertTypeDtoToType(type)).getId();
    }

    @Override
    public Optional<TypeDTO> updateType(TypeDTO typeToUpdate, Integer typeId) {
        return typeRepository.findById(typeId)
                .map(existing -> {
                    existing.setName(typeToUpdate.getTypeName());

                    return convertTypeToTypeDTO(typeRepository.save(existing));
                });
    }

    public TypeDTO convertTypeToTypeDTO(Type type) {
        return new TypeDTO(type.getName());
    }

    public Type convertTypeDtoToType(TypeDTO typeDTO) {
        Type newType = new Type();
        newType.setName(typeDTO.getTypeName());

        return newType;
    }
}
