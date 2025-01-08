package io.iochord.pim_project.prj_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="pim_m_prj")
public class PimMPrj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "prj_cd")
    private String prjCd;
    @Column(name = "prj_nm")
    private String prjNm;
    @Column(name = "user_id")
    private Long userId;
    @CreationTimestamp
    @Column(name = "created_dt")
    private Timestamp createdDt;
    @Column(name = "status")
    private String status;
    @UpdateTimestamp
    @Column(name = "modified_dt")
    private Timestamp modifiedDt;
}
