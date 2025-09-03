package ek.osnb.jparelations2.m2m.repository;

import ek.osnb.jparelations2.m2m.model.Course;
import ek.osnb.jparelations2.m2m.repository.projections.CourseWithoutStudents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<CourseWithoutStudents> findAllBy();
}
