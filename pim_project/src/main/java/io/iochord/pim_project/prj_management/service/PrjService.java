package io.iochord.pim_project.prj_management.service;

import io.iochord.pim_project.apqp_management.dto.ApqpResDto;
import io.iochord.pim_project.apqp_management.model.PimMApqp;
import io.iochord.pim_project.prj_management.dto.PrjReqDto;
import io.iochord.pim_project.prj_management.dto.PrjResDto;
import io.iochord.pim_project.prj_management.model.PimMPrj;
import io.iochord.pim_project.prj_management.repository.PrjRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Date.from;

@Service
@RequiredArgsConstructor
@Transactional
public class PrjService {

    private final PrjRepository prjRepository;

    public PrjResDto getProject(Long projectId){
        Optional<PimMPrj> pimMPrjOpt = prjRepository.findById(projectId);

        PimMPrj pimMPrj = pimMPrjOpt.orElse(null);

        System.out.println(pimMPrj);
        if(pimMPrj != null){
            List<PimMApqp> apqpList = pimMPrj.getApqpList();
            List<ApqpResDto> apqpResDtoList = new ArrayList<>();
            for(PimMApqp pimMApqp : apqpList){
                apqpResDtoList.add(
                        ApqpResDto.builder()
                                .id(pimMApqp.getId())
                                .apqpRole(pimMApqp.getApqpRole())
                                .userId(pimMApqp.getUserId())
                                .build()
                );
            }

            PrjResDto prjResDto = PrjResDto.builder()
                    .id(pimMPrj.getId())
                    .prjCd(pimMPrj.getPrjCd())
                    .prjNm(pimMPrj.getPrjNm())
                    .userId(pimMPrj.getUserId())
                    .createdDt(pimMPrj.getCreatedDt())
                    .status(pimMPrj.getStatus())
                    .modifiedDt(pimMPrj.getModifiedDt())
                    .apqpList(apqpResDtoList)
                    .build();

            return prjResDto;
        }

        return null;
    }

    public PrjResDto createProject(PrjReqDto prjReqDto){
        PimMPrj pimMPrj = PimMPrj.builder()
                .id(prjReqDto.getId())
                .prjCd(prjReqDto.getPrjCd())
                .prjNm(prjReqDto.getPrjNm())
                .status(prjReqDto.getStatus())
                .userId(prjReqDto.getUserId())
                .build();

        prjRepository.save(pimMPrj);

        PrjResDto prjResDto = PrjResDto.builder()
                .id(pimMPrj.getId())
                .prjCd(pimMPrj.getPrjCd())
                .prjNm(pimMPrj.getPrjNm())
                .status(pimMPrj.getStatus())
                .userId(pimMPrj.getUserId())
                .createdDt(Timestamp.from(Instant.now()))
                .modifiedDt(Timestamp.from(Instant.now()))
                .build();

        return prjResDto;
    }

    public PrjResDto updateProject(Long id, PrjReqDto prjReqDto){
        PimMPrj pimMPrj1 = prjRepository.findById(id).orElse(
            null
        );

        if (pimMPrj1 != null){
            pimMPrj1.setPrjNm(prjReqDto.getPrjNm());
            pimMPrj1.setStatus(prjReqDto.getStatus());

            PimMPrj updateCode = prjRepository.save(pimMPrj1);

            return PrjResDto.builder()
                    .id(updateCode.getId())
                    .prjCd(updateCode.getPrjCd())
                    .prjNm(updateCode.getPrjNm())
                    .userId(updateCode.getUserId())
                    .status(updateCode.getStatus())
                    .build();
        }

        return null;
    }

    /*
    public void delete(Long id){
        PimMPrj pimMPrj = new PimMPrj();
        pimMPrj.setId(id);
        prjRepository.delete(pimMPrj);
    }
     */



}
