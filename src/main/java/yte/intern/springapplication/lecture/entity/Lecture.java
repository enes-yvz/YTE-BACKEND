package yte.intern.springapplication.lecture.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.springapplication.common.entity.BaseEntity;
import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Lecture extends BaseEntity {

    private String name;

    private String code;
    private String location;

    private String instructor;

    private myType type;

    private myTime startTime;

    private myTime endTime;

    public void update(Lecture updatedLecture) {
        this.location = updatedLecture.location;
        this.startTime = updatedLecture.startTime;
        this.endTime = updatedLecture.endTime;
    }
}
