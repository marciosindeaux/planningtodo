package br.sindeaux.planningtod.planningtodo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_ATIVIDADE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    @Id
    @Column(name = "COD_ATIVIDADE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_GRUPO")
    private Group group;

    @Column(name = "DT_FIM")
    private LocalDate finishDate;

    @Column(name = "DT_ALARME")
    private LocalDateTime reminder;

    @Column(name = "ST_TERMINADO")
    private Boolean finish;

    @Column(name = "ST_FAVORITO")
    private Boolean favorite;

    @Column(name = "DS_ATIVIDADE")
    private String annotations;
}
