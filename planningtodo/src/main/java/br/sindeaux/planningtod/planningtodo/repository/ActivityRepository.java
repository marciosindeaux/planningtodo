package br.sindeaux.planningtod.planningtodo.repository;

import br.sindeaux.planningtod.planningtodo.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findAllByFinish(Boolean finish);
}
