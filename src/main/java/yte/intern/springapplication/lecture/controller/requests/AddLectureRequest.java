package yte.intern.springapplication.lecture.controller.requests;
import yte.intern.springapplication.lecture.entity.Lecture;
import yte.intern.springapplication.lecture.entity.myTime;
import yte.intern.springapplication.lecture.entity.myType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record AddLectureRequest(
        @NotBlank
        @Size(max = 25)
        String name,
        @NotBlank
        @Size(max = 10)
        String code,
        @NotBlank
        String location,
        @NotBlank
        String instructor,
        @NotBlank
        String type,
        @NotBlank
        String startTime,
        @NotBlank
        String endTime

) {

    public Lecture toDomainEntity() {

        myTime startTime = myTime.FIRST;
        myTime endTime = myTime.FIRST;

        switch (this.startTime) {
            case "09:40" -> startTime = myTime.SECOND;
            case "10:40" -> startTime = myTime.THIRD;
            case "11:40" -> startTime = myTime.FOURTH;
            case "13:40" -> startTime = myTime.FIFTH;
            case "14:40" -> startTime = myTime.SIXTH;
            case "15:40" -> startTime = myTime.SEVENTH;
            case "16:40" -> startTime = myTime.EIGHTH;
        }

        switch (this.endTime) {
            case "10:30" -> endTime = myTime.SECOND;
            case "11:30" -> endTime = myTime.THIRD;
            case "12:30" -> endTime = myTime.FOURTH;
            case "14:30" -> endTime = myTime.FIFTH;
            case "15:30" -> endTime = myTime.SIXTH;
            case "16:30" -> endTime = myTime.SEVENTH;
            case "17:30" -> endTime = myTime.EIGHTH;
        }



        return new Lecture(name,code,location,instructor,myType.valueOf(type),startTime,endTime);
    }
}
