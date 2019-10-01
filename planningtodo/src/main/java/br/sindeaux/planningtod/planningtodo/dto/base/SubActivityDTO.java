package br.sindeaux.planningtod.planningtodo.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubActivityDTO {
    private Long id;

    private LocalDate finishDate;

    private Boolean finish;

    private String annotations;

    private ActivityDTO activity;

}
