package io.iochord.pim_project.apqp_management.controller;

import io.iochord.pim_project.apqp_management.dto.ApqpReqDto;
import io.iochord.pim_project.apqp_management.dto.ApqpResDto;
import io.iochord.pim_project.apqp_management.service.ApqpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apqp")
@RequiredArgsConstructor
public class ApqpController {

    private final ApqpService apqpService;

    @GetMapping("/{id}")
    public ApqpResDto apqpResDto(@PathVariable("id") Long id){
        return apqpService.getApqp(id);
    }

    @PostMapping("/create")
    public ApqpResDto apqpResDto(@RequestBody ApqpReqDto apqpReqDto){
        return apqpService.createApqp(apqpReqDto);
    }

}
