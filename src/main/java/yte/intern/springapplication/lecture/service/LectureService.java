package yte.intern.springapplication.lecture.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.common.response.ResponseType;
import yte.intern.springapplication.lecture.entity.Lecture;
import yte.intern.springapplication.lecture.repository.LectureRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    public MessageResponse addLecture(Lecture lecture) {
        lectureRepository.save(lecture);

        return new MessageResponse(ResponseType.SUCCESS, "Lecture has been added successfully");
    }

    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    public Lecture getById(Long id) {
        return lectureRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lecture not found"));
    }

    public MessageResponse deleteLectureById(Long id) {
        lectureRepository.deleteById(id);

        return new MessageResponse(ResponseType.SUCCESS, "Lecture has been deleted successfully");
    }

    public MessageResponse updateLecture(Long id, Lecture updatedLecture) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lecture not found"));

        lecture.update(updatedLecture);

        lectureRepository.save(lecture);

        return new MessageResponse(ResponseType.SUCCESS, "Lecture has been updated successfully");
    }
}
