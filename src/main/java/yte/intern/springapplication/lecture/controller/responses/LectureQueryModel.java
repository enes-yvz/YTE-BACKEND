package yte.intern.springapplication.lecture.controller.responses;
import yte.intern.springapplication.lecture.entity.Lecture;
import yte.intern.springapplication.lecture.entity.myTime;
import yte.intern.springapplication.lecture.entity.myType;
import yte.intern.springapplication.user.entity.User;

public record LectureQueryModel(
        Long id,
        String name,
        myType type,
        String code,
        String location,
        String instructor,
        String startTime,
        String endTime
) {

    public LectureQueryModel(Lecture lecture) {

        this(

                lecture.getId(),
                lecture.getName(),
                lecture.getType(),
                lecture.getCode(),
                lecture.getLocation(),
                lecture.getInstructor().getUsername(),
                lecture.getStartTime(),
                lecture.getEndTime()
        );
    }
}
