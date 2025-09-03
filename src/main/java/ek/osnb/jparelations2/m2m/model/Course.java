package ek.osnb.jparelations2.m2m.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import ek.osnb.jparelations2.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Course extends BaseEntity {
    private String title;
    private int ects;

    @ManyToMany(mappedBy = "courses")
    @JsonManagedReference
    private Set<Student> students = new HashSet<>();

    public Set<Student> getStudents() {
        return students;
    }

    void addStudent(Student student) {
        if (student == null ) {
            return;
        }
        this.students.add(student);
    }

    void removeStudent(Student student) {
        if (student == null ) {
            return;
        }
        this.students.remove(student);
    }

    public Course() {}

    public Course(String title, int ects) {
        this.title = title;
        this.ects = ects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }
}
