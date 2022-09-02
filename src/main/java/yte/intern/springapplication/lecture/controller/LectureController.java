package yte.intern.springapplication.lecture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.common.response.ResponseType;
import yte.intern.springapplication.lecture.controller.requests.AddLectureRequest;
import yte.intern.springapplication.lecture.controller.requests.UpdateLectureRequest;
import yte.intern.springapplication.lecture.controller.responses.LectureQueryModel;
import yte.intern.springapplication.lecture.service.LectureService;
import yte.intern.springapplication.user.entity.Role;
import yte.intern.springapplication.user.entity.User;
import yte.intern.springapplication.user.service.CustomUserDetailsService;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/lecture")
@RequiredArgsConstructor
@Validated
public class LectureController {

    private final LectureService lectureService;

    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping
    public MessageResponse addLecture(@Valid @RequestBody AddLectureRequest addLectureRequest) {
        User user = customUserDetailsService.findUserByUsername(addLectureRequest.getInstructor());
        if (user.getRole().equals(Role.INSTRUCTOR)) {
            return lectureService.addLecture(addLectureRequest.toDomainEntity(user));
        }
        else {
            return new MessageResponse(ResponseType.ERROR, "User isn't instructor");
        }

    }

    @GetMapping
    public List<LectureQueryModel> getAllLectures() {
        return lectureService.getAllLectures()
                .stream()
                .map(lecture -> new LectureQueryModel(lecture))
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

    /*@PutMapping()
    public MessageResponse updateAll(@Valid @RequestBody List<UpdateLectureRequest> updateLectureRequestList) {

        return lectureService.updateAll(updateLectureRequestList);
    }*/
}
