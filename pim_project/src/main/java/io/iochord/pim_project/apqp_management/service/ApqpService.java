package io.iochord.pim_project.apqp_management.service;

import io.iochord.pim_project.apqp_management.dto.ApqpReqDto;
import io.iochord.pim_project.apqp_management.dto.ApqpResDto;
import io.iochord.pim_project.apqp_management.model.PimMApqp;
import io.iochord.pim_project.apqp_management.repository.ApqpRepository;
import io.iochord.pim_project.prj_management.dto.PrjResDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ApqpService {

    private final ApqpRepository apqpRepository;

    public ApqpResDto getApqp(Long id){
        Optional<PimMApqp> pimMApqpOpt = apqpRepository.findById(id);

        PimMApqp pimMApqp = pimMApqpOpt.orElse(null);

        if(pimMApqp != null){
            ApqpResDto apqpResDto = ApqpResDto.builder()
                    .id(pimMApqp.getId())
                    .prjId(pimMApqp.getPrjId())
                    .apqpRole(pimMApqp.getApqpRole())
                    .userId(pimMApqp.getUserId())
                    .modifiedDt(pimMApqp.getModifiedDt())
                    .required(pimMApqp.getRequired())
                    .build();

            return apqpResDto;
        }
        return null;
    }

    public ApqpResDto createApqp(ApqpReqDto apqpReqDto){
        PimMApqp pimMApqp = PimMApqp.builder()
                .id(apqpReqDto.getId())
                .prjId(apqpReqDto.getPrjId())
                .apqpRole(apqpReqDto.getApqpRole())
                .userId(apqpReqDto.getUserId())
                .required(apqpReqDto.getRequired())
                .build();
        System.out.println(pimMApqp);

        apqpRepository.save(pimMApqp);
        System.out.println(pimMApqp);
        ApqpResDto apqpResDto1 = ApqpResDto.builder()
                .id(pimMApqp.getId())
                .prjId(pimMApqp.getPrjId())
                .apqpRole(pimMApqp.getApqpRole())
                .userId(pimMApqp.getUserId())
                .required(pimMApqp.getRequired())
                .modifiedDt(pimMApqp.getModifiedDt())
                .build();
        System.out.println(apqpResDto1);
        return apqpResDto1;
    }


}
