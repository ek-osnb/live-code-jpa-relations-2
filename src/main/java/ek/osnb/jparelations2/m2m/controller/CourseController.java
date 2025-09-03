package ek.osnb.jparelations2.m2m.controller;

import ek.osnb.jparelations2.m2m.repository.CourseRepository;
import ek.osnb.jparelations2.m2m.repository.projections.CourseWithoutStudents;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public ResponseEntity<List<CourseWithoutStudents>> getAllCourses() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("------- get method course controller -------");
        return ResponseEntity.ok(courseRepository.findAllBy());
    }
}
