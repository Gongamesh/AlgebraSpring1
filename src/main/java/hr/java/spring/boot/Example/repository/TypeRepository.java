package hr.java.spring.boot.Example.repository;

import hr.java.spring.boot.Example.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
    List<Type> findByNameContaining(String typeName);
}
