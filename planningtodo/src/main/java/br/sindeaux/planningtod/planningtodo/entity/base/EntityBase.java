package br.sindeaux.planningtod.planningtodo.entity.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntityBase {

    @Column(name = "DT_CRIACAO",nullable = false,insertable = false,updatable = false)
    private LocalDateTime create = LocalDateTime.now();
}
