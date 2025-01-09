package io.iochord.pim_project.apqp_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="pim_m_apqp")
public class PimMApqp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @JoinColumn(name="id", referencedColumnName = "id", nullable = true)
    @Column(name = "prj_id")
    private Long prjId;
    @Column(name = "apqp_role")
    private String apqpRole;
    @JoinColumn(nullable = true)
    @Column(name = "user_id")
    private Long userId;
    @UpdateTimestamp
    @Column(name = "modified_dt")
    private Timestamp modifiedDt;
    @Column(name = "required")
    private Boolean required;

}
