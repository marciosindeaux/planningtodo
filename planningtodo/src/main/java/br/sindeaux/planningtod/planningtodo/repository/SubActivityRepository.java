package br.sindeaux.planningtod.planningtodo.repository;

import br.sindeaux.planningtod.planningtodo.entity.SubActivitys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubActivityRepository extends JpaRepository<SubActivitys, Long> {

    List<SubActivitys> findAllByActivity_Id(Long id);
}
