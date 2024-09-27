package io.iochord.demo.controller;
import io.iochord.demo.dto.ActivitycodeResDTO;
import io.iochord.demo.service.ActivitycodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/activitycode") // properties 에 있는 url 뒤에 붙일 url
@RequiredArgsConstructor // private final 과 붙여서 사용. 해당 인자가 들어가야하는 class를 생성
public class ActivitycodeController {
    private final ActivitycodeService activitycodeService;
    @GetMapping
    public List<ActivitycodeResDTO> getAllCode() {
        List<ActivitycodeResDTO> activitycodeList = activitycodeService.getAllCode();
        return activitycodeList;
    }

    @GetMapping("/{id}")
    public ActivitycodeResDTO getCodeById(@PathVariable("id") String activitycode){
        return activitycodeService.getCodeById(activitycode);
    }

    @PatchMapping
    public ActivitycodeResDTO update(@RequestBody ActivitycodeResDTO activitycodeResDTO){ //json 형태

        ActivitycodeResDTO activitycode = null;
        try {
            activitycode = activitycodeService.update(activitycodeResDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return activitycode;

    }

    @PostMapping
    public ActivitycodeResDTO post(@RequestBody ActivitycodeResDTO activitycodeResDTO){
        return activitycodeService.post(activitycodeResDTO);
    }

    @PutMapping
    public ActivitycodeResDTO put(@RequestBody ActivitycodeResDTO activitycodeResDTO){
        return activitycodeService.put(activitycodeResDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String activitycode){
        activitycodeService.delete(activitycode);
        return new ResponseEntity<>("삭제 성공", HttpStatus.OK);
    }
}
