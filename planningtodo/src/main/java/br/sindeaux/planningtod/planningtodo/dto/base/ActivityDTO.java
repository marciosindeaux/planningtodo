package br.sindeaux.planningtod.planningtodo.dto.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO{

    private Long id;

    private GroupDTO group;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate finishDate;

    private LocalDateTime reminder;

    private boolean finish;

    private boolean favorite;

    @NotNull @NotEmpty @NotBlank
    private String annotations;

    private List<SubActivityDTO> subActivitysList;
}
