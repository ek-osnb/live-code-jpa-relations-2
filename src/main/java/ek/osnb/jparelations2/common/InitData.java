package ek.osnb.jparelations2.common;

import ek.osnb.jparelations2.m2m.model.Course;
import ek.osnb.jparelations2.m2m.model.Student;
import ek.osnb.jparelations2.m2m.repository.CourseRepository;
import ek.osnb.jparelations2.m2m.repository.StudentRepository;
import ek.osnb.jparelations2.one2one.User;
import ek.osnb.jparelations2.one2one.UserDetails;
import ek.osnb.jparelations2.one2one.UserDetailsRepository;
import ek.osnb.jparelations2.one2one.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitData implements CommandLineRunner {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    private final UserDetailsRepository userDetailsRepository;

    private final UserRepository userRepository;

    public InitData(CourseRepository courseRepository, StudentRepository studentRepository,
                    UserDetailsRepository userDetailsRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;

        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        initManyToManyData();
        initOneToOne();
    }

    private void initOneToOne() {
        User u1 = new User("Osman");
        User u2 = new User("Osman2");
        UserDetails ud1 = new UserDetails("Hello world");
        UserDetails ud2 = new UserDetails("Hello world 2");

        userDetailsRepository.saveAll(List.of(ud1,ud2));

        u1.setUserDetails(ud1);
        u2.setUserDetails(ud2);

        userRepository.saveAll(List.of(u1,u2));



    }

    private void initManyToManyData() {
        Student s1 = new Student("John", "john@ek.dk");
        Student s2 = new Student("Jane", "jane@ek.dk");
        Student s3 = new Student("Jack", "jack@ek.dk");
        Student s4 = new Student("Jill", "jill@ek.dk");

        Course c1 = new Course("PROG2", 10);
        System.out.println("BEFORE PERSISTENCE = " + c1.getId());
        Course c2 = new Course("TEK2", 10);
        Course c3 = new Course("SYS2", 10);
        Course c4 = new Course("SYS", 10);
        Course c5 = new Course("PROG", 10);
        Course c6 = new Course("TEK", 10);


        courseRepository.saveAll(List.of(c1,c2,c3, c4, c5,c6));
        System.out.println("AFTER PERSISTENCE = " + c1.getId());

        s1.addToCourse(c1);
        s2.addToCourse(c1);
        s1.addToCourse(c2);
        s1.addToCourse(c3);

        studentRepository.saveAll(List.of(s1, s2, s3, s4));

        System.out.println("Students in course = " + c1.getStudents().size());
    }
}
