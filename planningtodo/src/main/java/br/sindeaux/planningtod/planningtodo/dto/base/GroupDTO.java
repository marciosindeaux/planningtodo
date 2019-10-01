package br.sindeaux.planningtod.planningtodo.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO {

    private Long id;

    private String tittle;

    private List<ActivityDTO> activityList;
}
