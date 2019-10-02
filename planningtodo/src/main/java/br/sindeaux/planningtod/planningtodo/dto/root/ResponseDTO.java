package br.sindeaux.planningtod.planningtodo.dto.root;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

    private Object data;

    private String msg;

    private HttpStatus httpStatus;
}
