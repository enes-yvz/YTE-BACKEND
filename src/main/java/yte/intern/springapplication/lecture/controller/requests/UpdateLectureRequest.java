package yte.intern.springapplication.lecture.controller.requests;

import yte.intern.springapplication.lecture.entity.Lecture;

public record UpdateLectureRequest(
        String name,
        String surname,
        String email
) {

    public Lecture toDomainEntity() {
        return new Lecture(name, surname, email,null);
    }
}
