package yte.intern.springapplication.lecture.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.springapplication.common.entity.BaseEntity;
import yte.intern.springapplication.user.entity.User;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Lecture extends BaseEntity {

    private String name;

    private String code;
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academician_id", referencedColumnName = "id")
    private User instructor;

    private myType type;

    private myTime startTime;

    private myTime endTime;

    public void update(Lecture updatedLecture) {
        this.location = updatedLecture.location;
        this.startTime = updatedLecture.startTime;
        this.endTime = updatedLecture.endTime;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getLocation() {
        return location;
    }

    public User getInstructor() {
        return instructor;
    }

    public myType getType() {
        return type;
    }

    public String getStartTime() {

        String startTime = "08:40";

        switch (this.startTime) {
            case SECOND -> startTime = "09:40";
            case THIRD -> startTime = "10:40";
            case FOURTH -> startTime = "11:40";
            case FIFTH -> startTime = "13:40";
            case SIXTH -> startTime = "14:40";
            case SEVENTH -> startTime = "15:40";
            case EIGHTH -> startTime = "16:40";
        }

        return startTime;
    }

    public String getEndTime() {

        String endTime = "09:30";

        switch (this.startTime) {
            case SECOND ->endTime ="10:30" ;
            case THIRD -> endTime = "11:30" ;
            case FOURTH ->endTime ="12:30" ;
            case FIFTH -> endTime = "14:30" ;
            case SIXTH -> endTime = "15:30" ;
            case SEVENTH ->endTime = "16:30";
            case EIGHTH ->endTime ="17:30" ;
        }
        return endTime;
    }
}
