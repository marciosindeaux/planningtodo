package br.sindeaux.planningtod.planningtodo.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubActivityDTO {

    private Long id;

    private LocalDate finishDate;

    private boolean finish;

    @NotNull @NotEmpty @NotBlank
    private String annotations;

    @NotNull
    private ActivityDTO activity;

}
