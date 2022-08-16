package yte.intern.springapplication.lecture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.lecture.controller.requests.AddLectureRequest;
import yte.intern.springapplication.lecture.controller.requests.UpdateLectureRequest;
import yte.intern.springapplication.lecture.controller.responses.LectureQueryModel;
import yte.intern.springapplication.lecture.service.LectureService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Validated
public class LectureController {

    private final LectureService lectureService;

    @PostMapping
    public MessageResponse addLecture(@Valid @RequestBody AddLectureRequest addLectureRequest) {
        return lectureService.addLecture(addLectureRequest.toDomainEntity());
    }

    @GetMapping
    public List<LectureQueryModel> getAllLectures() {
        return lectureService.getAllLectures()
                .stream()
                .map(student -> new LectureQueryModel(student))
                .toList();
    }

    @GetMapping("/{id}")
    public LectureQueryModel getById(@NotNull @PathVariable Long id) {
        return new LectureQueryModel(lectureService.getById(id));
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteLectureById(@PathVariable @NotNull Long id) {
        return lectureService.deleteLectureById(id);
    }

    @PutMapping("/{id}")
    public MessageResponse updateLecture(@Valid @RequestBody UpdateLectureRequest request, @PathVariable Long id) {
        return lectureService.updateLecture(id, request.toDomainEntity());
    }
}
