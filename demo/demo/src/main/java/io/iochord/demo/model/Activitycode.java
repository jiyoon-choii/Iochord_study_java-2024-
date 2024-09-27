package io.iochord.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id; // *jakarta에 대해 알아보기
import lombok.*;

@Getter
@Setter
@Entity //DB와 연결
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activitycode {
    @Id //PK
    private String activitycode;
    private String activityname;
    private String template;

    /*
    public void setActivitycode(String activitycode){
        this.activitycode = activitycode;
    }
    */
}


