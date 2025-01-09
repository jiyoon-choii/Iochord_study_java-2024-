package io.iochord.pim_project.prj_management.dto;

import io.iochord.pim_project.apqp_management.dto.ApqpResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrjResDto {
    private Long id;
    private String prjCd;
    private String prjNm;
    private Long userId;
    private Timestamp createdDt;
    private String status;
    private Timestamp modifiedDt;

    private List<ApqpResDto> apqpList;

}
