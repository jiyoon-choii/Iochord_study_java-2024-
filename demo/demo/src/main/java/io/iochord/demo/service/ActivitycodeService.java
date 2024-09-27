package io.iochord.demo.service;

import io.iochord.demo.dto.ActivitycodeResDTO;
import io.iochord.demo.model.Activitycode;
import io.iochord.demo.repository.ActivitycodeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional // sql 작업 선언
public class ActivitycodeService {

    private final ActivitycodeRepository activitycodeRepository;

    public List<ActivitycodeResDTO> getAllCode() {

    List<Activitycode> activitycodeList = activitycodeRepository.findAll();
    List<ActivitycodeResDTO> dtoList = new ArrayList<>();
        for (int i = 0; i<activitycodeList.size(); i++){
            System.out.println(activitycodeList.get(i));
            Activitycode activitycode = activitycodeList.get(i);
            ActivitycodeResDTO activitycodeResDTO = ActivitycodeResDTO.builder()
                    .activitycode(activitycode.getActivitycode())
                    .activityname(activitycode.getActivityname())
                    .template(activitycode.getTemplate())
                    .build();
            dtoList.add(activitycodeResDTO);
        }
        return dtoList;
    }

            /* @builder를 사용하지 않으면 아래와 같이 작성해야 함
            ActivitycodeResDTO activitycodeResDTO = new ActivitycodeResDTO();
            activitycodeResDTO.setActivitycode(activitycode.getActivitycode());
            activitycodeResDTO.setActivityname(activitycode.getActivityname());
            activitycodeResDTO.setTemplate(activitycode.getTemplate());
            */

    //read
    public ActivitycodeResDTO getCodeById(String activitycode){
        Optional<Activitycode> activitycodeOptional = activitycodeRepository.findById(activitycode);
        if (activitycodeOptional.isPresent()) {
            Activitycode activitycode1 = activitycodeOptional.get();
            ActivitycodeResDTO activitycodeResDTO = ActivitycodeResDTO.builder()
                    .activitycode(activitycode1.getActivitycode())
                    .activityname(activitycode1.getActivityname())
                    .template(activitycode1.getTemplate())
                    .build();
            return activitycodeResDTO;
        }
        return null;

    }

    //update
    public ActivitycodeResDTO update(ActivitycodeResDTO activitycodeResDTO) throws Exception {
        Activitycode activitycode1 = activitycodeRepository.findById(activitycodeResDTO.getActivitycode()).orElse(
            null
                //() -> new IllegalArgumentException("해당 데이터가 존재하지 않습니다.")
        );
        if (activitycode1 != null){
            activitycode1.setActivityname(activitycodeResDTO.getActivityname());
            activitycode1.setTemplate(activitycodeResDTO.getTemplate());

            Activitycode updatedCode = activitycodeRepository.save(activitycode1);

            return ActivitycodeResDTO.builder()
                    .activitycode(updatedCode.getActivitycode())
                    .activityname(updatedCode.getActivityname())
                    .template(updatedCode.getTemplate())
                    .build();
        } else {
            throw new Exception();
        }

        }

    //post
    public ActivitycodeResDTO post(ActivitycodeResDTO activitycodeResDTO){
        Activitycode activitycode1 = new Activitycode();
        activitycode1.setActivitycode(activitycodeResDTO.getActivitycode());
        activitycode1.setActivityname(activitycodeResDTO.getActivityname());
        activitycode1.setTemplate(activitycodeResDTO.getTemplate());

        Activitycode postDTO = activitycodeRepository.save(activitycode1);

        return ActivitycodeResDTO.builder()
                .activitycode(postDTO.getActivitycode())
                .activityname(postDTO.getActivityname())
                .template(postDTO.getTemplate())
                .build();
    }

    //put
    public ActivitycodeResDTO put(ActivitycodeResDTO activitycodeResDTO){
        Activitycode activitycode1 = new Activitycode();
        activitycode1.setActivitycode(activitycodeResDTO.getActivitycode());
        activitycode1.setActivityname(activitycodeResDTO.getActivityname());
        activitycode1.setTemplate(activitycodeResDTO.getTemplate());

        Activitycode putDTO = activitycodeRepository.save(activitycode1);

        return ActivitycodeResDTO.builder()
                .activitycode(putDTO.getActivitycode())
                .activityname(putDTO.getActivityname())
                .template(putDTO.getTemplate())
                .build();
    }

    //delete
    public void delete(String activitycode){
        Activitycode activitycode1 = new Activitycode();
        activitycode1.setActivitycode(activitycode);
        activitycodeRepository.delete(activitycode1);
    }

}
