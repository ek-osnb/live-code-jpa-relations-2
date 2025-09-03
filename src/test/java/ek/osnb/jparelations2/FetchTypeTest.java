package ek.osnb.jparelations2;

import ek.osnb.jparelations2.m2m.model.Course;
import ek.osnb.jparelations2.m2m.model.Student;
import ek.osnb.jparelations2.m2m.repository.CourseRepository;
import ek.osnb.jparelations2.m2m.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class FetchTypeTest {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    EntityManager em;

    @BeforeEach
    void setUp() {
        em.flush();
        em.clear();
    }

    @Test
    void fetchTypeExample() {
        Student s1 = new Student("John", "john@ek.dk");
        Student s2 = new Student("Jane", "jane@ek.dk");
        Course c1 = new Course("PROG2", 10);
//        Course c2 = new Course("TEK2", 10);
        courseRepository.saveAll(List.of(c1));
        s1.addToCourse(c1);
        s2.addToCourse(c1);
        studentRepository.saveAll(List.of(s1,s2));
        em.flush();
        em.clear();

        //
        System.out.println("------ TEST FETCH -----");
        List<Course> courses = courseRepository.findAll();
        var course = courses.getFirst();

        for (var c : courses) {
            var s = c.getStudents();
            System.out.println("Is initialized? " + Hibernate.isInitialized(s));

            s.size();

            System.out.println("Is initialized 2? " + Hibernate.isInitialized(s));


        }

    }


}
