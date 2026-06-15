package hr.java.spring.boot.Example.repository.impl;

import hr.java.spring.boot.Example.domain.Hardware;
import hr.java.spring.boot.Example.mapper.HardwareMapper;
import hr.java.spring.boot.Example.repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Primary
@Repository
@AllArgsConstructor
public class JdbcHardwareRepository implements HardwareRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Hardware> getAllHardware() {
        return jdbcTemplate.query("SELECT * FROM Hardware", new HardwareMapper());
    }

    @Override
    public List<Hardware> getHardwareByCode(String hardwareCode) {
        return jdbcTemplate.query("SELECT * FROM Hardware WHERE Code = ?", new HardwareMapper(), hardwareCode);
    }

    @Override
    public Integer saveNewHardware(Hardware hardware) {
        final String SQL =
                "INSERT INTO Hardware(Code, Name, Price, Available, CategoryFK)" +
                        "OUTPUT INSERTED.Id" +
                        " VALUES(?,?,?,?,?)";

        Integer generatedId = jdbcTemplate.queryForObject(SQL, Integer.class, hardware.getCode(),
                hardware.getName(),
                hardware.getPrice(),
                hardware.getAvailable(),
                hardware.getCategory().getId());

        hardware.setId(generatedId);

        return generatedId;
    }

    @Override
    public Optional<Hardware> updateHardware(Hardware hardwareToUpdate, String hardwareCode) {
        if (hardwareByIdExists(hardwareCode)) {
            final String SQL = "UPDATE Hardware SET Name = ?, Price = ?, Available = ?, CategoryFK = ? " +
                    "WHERE Code = ?";

            jdbcTemplate.update(SQL, hardwareToUpdate.getName(),
                    hardwareToUpdate.getPrice(),
                    hardwareToUpdate.getAvailable(),
                    hardwareToUpdate.getCategory().getId(),
                    hardwareCode);

            return Optional.of(hardwareToUpdate);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean hardwareByIdExists(String hradwareCode) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM Hardware WHERE Code = ?", Integer.class, hradwareCode
        );

        return count > 0;
    }

    @Override
    public boolean deleteHardwareByCode(String hardwareCode) {
        if(hardwareByIdExists(hardwareCode)) {
            jdbcTemplate.update("DELETE FROM Hardware WHERE Code = ?", hardwareCode);
            return true;
        } else {
            return false;
        }
    }
}
