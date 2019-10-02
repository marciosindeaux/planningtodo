package br.sindeaux.planningtod.planningtodo.controller;

import br.sindeaux.planningtod.planningtodo.dto.root.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface AbstractController {

    default  ResponseEntity response(Object data, String msg, HttpStatus status){
        return new ResponseEntity(new ResponseDTO(data,msg,status), status);
    }

    default ResponseEntity tryResponse(Object data){
        return response(data,"Ação realizada com sucesso",HttpStatus.OK);
    }

    default ResponseEntity tryResponse(){
        return tryResponse(null);
    }

    default ResponseEntity catchResponse(String msg){
        return response(null,msg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    default ResponseEntity catchResponse(){
        return catchResponse("Não foi possivel Realizar Ação");
    }

    default ResponseEntity catchResponse(Exception e){
        return catchResponse(e.getMessage());
    }

    default ResponseEntity catchResponse(String msg, HttpStatus httpStatus){
        return response(null, msg,httpStatus);
    }

}
