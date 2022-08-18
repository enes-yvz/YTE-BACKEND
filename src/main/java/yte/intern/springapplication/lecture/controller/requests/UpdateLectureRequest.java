package yte.intern.springapplication.lecture.controller.requests;

import yte.intern.springapplication.lecture.entity.Lecture;
import yte.intern.springapplication.lecture.entity.myTime;

public record UpdateLectureRequest(
        String location,
        myTime startTime,
        myTime endTime
) {

    public Lecture toDomainEntity() {
        return new Lecture(null,null,null,location,null,startTime,endTime);
    }
}
