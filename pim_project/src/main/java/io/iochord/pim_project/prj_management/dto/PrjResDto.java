package io.iochord.pim_project.prj_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

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

}
