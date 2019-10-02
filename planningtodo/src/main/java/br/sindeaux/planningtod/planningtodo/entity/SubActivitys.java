package br.sindeaux.planningtod.planningtodo.entity;

import br.sindeaux.planningtod.planningtodo.entity.base.EntityBase;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "SUB_ATIVIDADES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SubActivitys extends EntityBase {

    @Id
    @Column(name = "COD_SUB_ATIVIDADE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DT_FIM")
    private LocalDate finishDate;

    @Column(name = "ST_TERMINADO")
    private Boolean finish;


    @Column(name = "DS_ATIVIDADE")
    private String annotations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_ATIVIDADE")
    private Activity activity;
}
