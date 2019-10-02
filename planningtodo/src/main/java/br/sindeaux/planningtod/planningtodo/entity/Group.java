package br.sindeaux.planningtod.planningtodo.entity;

import br.sindeaux.planningtod.planningtodo.entity.base.EntityBase;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_GRUPO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Group extends EntityBase {

    @Id
    @Column(name = "COD_GRUPO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DS_GRUPO")
    private String tittle;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<Activity> activityList;
}
