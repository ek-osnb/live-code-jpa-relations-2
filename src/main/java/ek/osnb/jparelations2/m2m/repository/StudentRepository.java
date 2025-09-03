package ek.osnb.jparelations2.m2m.repository;

import ek.osnb.jparelations2.m2m.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
