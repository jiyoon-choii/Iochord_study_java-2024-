package io.iochord.demo.repository;

import io.iochord.demo.model.Activitycode;
import org.springframework.data.jpa.repository.JpaRepository; // SQL 문법 대신 사용
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitycodeRepository extends JpaRepository<Activitycode,String> {
}
