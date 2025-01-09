package io.iochord.pim_project.prj_management.dto;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrjReqDto {
    private Long id;
    private String prjCd;
    private String prjNm;
    private Long userId;
    private String status;

}
