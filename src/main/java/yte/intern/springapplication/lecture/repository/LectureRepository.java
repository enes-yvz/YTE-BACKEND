package yte.intern.springapplication.lecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.springapplication.lecture.entity.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

}
