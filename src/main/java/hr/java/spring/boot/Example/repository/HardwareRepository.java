package hr.java.spring.boot.Example.repository;

import hr.java.spring.boot.Example.domain.Hardware;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HardwareRepository extends JpaRepository<Hardware, Integer> {
    List<Hardware> findByCodeContaining(String hardwareCode);
    boolean existsByCode(String hardwareCode);
    void deleteByCode(String hardwareCode);
}
