package io.iochord.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getter,Setter,Tostring 등을 포함
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivitycodeResDTO {
    private String activitycode;
    private String activityname;
    private String template;
}
