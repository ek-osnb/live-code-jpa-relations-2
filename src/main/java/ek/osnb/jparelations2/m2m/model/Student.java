package ek.osnb.jparelations2.m2m.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ek.osnb.jparelations2.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Student extends BaseEntity {
    private String name;
    private String email;

    @ManyToMany
    @JsonBackReference
    private Set<Course> courses = new HashSet<>();

    public void addToCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    public void removeFromCourse(Course course) {
        courses.remove(course);
        course.removeStudent(this);
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public Student() {}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
