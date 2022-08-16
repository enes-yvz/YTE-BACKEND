package yte.intern.springapplication.lecture.controller.requests;
import yte.intern.springapplication.lecture.entity.Lecture;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record AddLectureRequest(
        @NotBlank
        @Size(max = 25)
        String name,
        @NotBlank
        @Size(max = 25)
        String surname,
        @Email
        String email,
        @NotBlank
        @Size(min = 7, max = 7)
        String studentNumber
) {

    public Lecture toDomainEntity() {
        return new Lecture(name, surname, email, studentNumber);
    }
}
