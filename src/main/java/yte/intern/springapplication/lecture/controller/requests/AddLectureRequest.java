package yte.intern.springapplication.lecture.controller.requests;
import lombok.Getter;
import lombok.Setter;
import yte.intern.springapplication.lecture.entity.Lecture;
import yte.intern.springapplication.lecture.entity.myTime;
import yte.intern.springapplication.lecture.entity.myType;
import yte.intern.springapplication.user.entity.User;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AddLectureRequest {
    @NotBlank
    @Size(max = 25)
    private String name;
    @NotBlank
    @Size(max = 10)
    private String code;
    @NotBlank
    private String location;
    @NotBlank
    private String instructor;
    @NotBlank
    private String type;
    @NotBlank
    private String startTime;
    @NotBlank
    private String endTime;

    private myTime myStartTime;

    private myTime myEndTime;

    public AddLectureRequest(String name, String code, String location, String instructor, String type, String startTime, String endTime) {
        this.name = name;
        this.code = code;
        this.location = location;
        this.instructor = instructor;
        this.type = type;
        this.startTime= startTime;
        this.endTime= endTime;
        this.myStartTime = myTime.FIRST;
        this.myEndTime = myTime.FIRST;


        switch (startTime) {
            case "09:40" -> this.myStartTime = myTime.SECOND;
            case "10:40" -> this.myStartTime = myTime.THIRD;
            case "11:40" -> this.myStartTime = myTime.FOURTH;
            case "13:40" -> this.myStartTime = myTime.FIFTH;
            case "14:40" -> this.myStartTime = myTime.SIXTH;
            case "15:40" -> this.myStartTime = myTime.SEVENTH;
            case "16:40" -> this.myStartTime = myTime.EIGHTH;
        }

        switch (endTime) {
            case "10:30" -> this.myEndTime= myTime.SECOND;
            case "11:30" -> this.myEndTime= myTime.THIRD;
            case "12:30" -> this.myEndTime= myTime.FOURTH;
            case "14:30" -> this.myEndTime= myTime.FIFTH;
            case "15:30" -> this.myEndTime= myTime.SIXTH;
            case "16:30" -> this.myEndTime= myTime.SEVENTH;
            case "17:30" -> this.myEndTime= myTime.EIGHTH;
        }
    }

    public Lecture toDomainEntity(User user) {
        return new Lecture(name,code,location,user,myType.valueOf(type),myStartTime,myEndTime);
    }

}
