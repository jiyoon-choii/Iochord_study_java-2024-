package io.iochord.pim_project.apqp_management.repository;

import io.iochord.pim_project.apqp_management.model.PimMApqp;
import io.iochord.pim_project.prj_management.repository.PrjRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ApqpRepository extends JpaRepository<PimMApqp, Long>{

}
