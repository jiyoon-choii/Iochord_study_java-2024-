package io.iochord.pim_project.apqp_management.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApqpReqDto {
    private Long id;
    private Long prjId;
    private String apqpRole;
    private Long userId;
    private Boolean required;
}
