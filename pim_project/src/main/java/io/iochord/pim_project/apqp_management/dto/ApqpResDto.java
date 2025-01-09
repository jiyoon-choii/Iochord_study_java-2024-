package io.iochord.pim_project.apqp_management.dto;

import java.sql.Timestamp;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApqpResDto {
    private Long id;
    private Long prjId;
    private String apqpRole;
    private Long userId;
    private Timestamp modifiedDt;
    private Boolean required;
}
