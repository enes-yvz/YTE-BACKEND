package yte.intern.springapplication.lecture.controller.responses;
import yte.intern.springapplication.lecture.entity.Lecture;
import yte.intern.springapplication.lecture.entity.myTime;
import yte.intern.springapplication.lecture.entity.myType;

public record LectureQueryModel(
        Long id,
        String name,
        myType type,
        String code,
        String location,
        String instructor,
        myTime startTime,
        myTime endTime
) {

    public LectureQueryModel(Lecture lecture) {
        this(
                lecture.getId(),
                lecture.getName(),
                lecture.getType(),
                lecture.getCode(),
                lecture.getLocation(),
                lecture.getInstructor(),
                lecture.getStartTime(),
                lecture.getEndTime()
        );
    }
}
