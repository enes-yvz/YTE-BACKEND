package yte.intern.springapplication.lecture.controller.responses;

import yte.intern.springapplication.lecture.entity.Lecture;

public record LectureQueryModel(
        Long id,
        String name,
        String surname,
        String email,
        String studentNumber
) {

    public LectureQueryModel(Lecture lecture) {
        this(
                lecture.getId(),
                lecture.getName(),
                lecture.getSurname(),
                lecture.getEmail(),
                lecture.getStudentNumber()
        );
    }
}
