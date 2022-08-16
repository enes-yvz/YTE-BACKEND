package yte.intern.springapplication.lecture.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.springapplication.common.entity.BaseEntity;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
public class Lecture extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String studentNumber;

    public Lecture(String name,
                   String surname,
                   String email,
                   String studentNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.studentNumber = studentNumber;
    }

    public void update(Lecture updatedLecture) {
        this.name = updatedLecture.name;
        this.surname = updatedLecture.surname;
        this.email = updatedLecture.email;
    }
}
