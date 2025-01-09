package io.iochord.pim_project.prj_management.controller;

import io.iochord.pim_project.prj_management.dto.PrjReqDto;
import io.iochord.pim_project.prj_management.dto.PrjResDto;
import io.iochord.pim_project.prj_management.service.PrjService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class PrjController {

    private final PrjService prjService;

    @GetMapping("/{projectId}")
    public PrjResDto getProject(@PathVariable("projectId") Long projectId){
        return prjService.getProject(projectId);
    }

    @PostMapping
    public PrjResDto createProject(@RequestBody PrjReqDto prjReqDto){
        return prjService.createProject(prjReqDto);
    }

    @PatchMapping("/{id}")
    public PrjResDto updateProject(@PathVariable("id") Long id, @RequestBody PrjReqDto prjReqDto){
        return prjService.updateProject(id, prjReqDto);
    }


    //전체 리드 //페이지 기능도
    //삭제
}
