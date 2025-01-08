package io.iochord.pim_project.prj_management.repository;

import io.iochord.pim_project.prj_management.model.PimMPrj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrjRepository extends JpaRepository<PimMPrj, Long> {

}
