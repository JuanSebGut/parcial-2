package co.edu.usco.pw.springboot_crud01.repository;

import co.edu.usco.pw.springboot_crud01.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findBysetSubjectName(String subjectName);
}
