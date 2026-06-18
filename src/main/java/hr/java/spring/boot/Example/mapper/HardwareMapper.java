package hr.java.spring.boot.Example.mapper;

import hr.java.spring.boot.Example.domain.Category;
import hr.java.spring.boot.Example.domain.Hardware;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class HardwareMapper implements RowMapper<Hardware> {

    @Override
    public Hardware mapRow(ResultSet rs, int rowNum) throws SQLException {
        Hardware hardware = new Hardware();

        hardware.setId(rs.getInt("Id"));
        hardware.setCode(rs.getString("Code"));
        hardware.setName(rs.getString("Name"));
        hardware.setPrice(rs.getBigDecimal("Price"));
        hardware.setAvailable(rs.getInt("Available"));
        //hardware.setCategory(Category.getCategoryFromId(rs.getInt("CategoryFK")));

        return hardware;
    }
}
