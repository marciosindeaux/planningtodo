package br.sindeaux.planningtod.planningtodo.repository;

import br.sindeaux.planningtod.planningtodo.entity.SubActivitys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubActivityRepository extends JpaRepository<SubActivitys, Long> {
}
