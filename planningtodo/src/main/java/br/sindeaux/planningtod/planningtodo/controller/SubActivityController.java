package br.sindeaux.planningtod.planningtodo.controller;

import br.sindeaux.planningtod.planningtodo.dto.base.SubActivityDTO;
import br.sindeaux.planningtod.planningtodo.entity.SubActivitys;
import br.sindeaux.planningtod.planningtodo.service.SubActivityService;
import br.sindeaux.planningtod.planningtodo.utils.ConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sub-activity")
public class SubActivityController implements  AbstractController{

    @Autowired
    private SubActivityService subActivityService;

    @PostMapping
    public ResponseEntity cadastrarSubAtividade(@RequestBody SubActivityDTO subActivityDTO){
        try{
            SubActivitys subActivity = ConverterUtils.convertTo(subActivityDTO, SubActivitys.class);
            subActivityService.salvarNovaSubAtividade(subActivity);
            return tryResponse();
        }catch (Exception e){
            return catchResponse();
        }
    }

    @PutMapping
    public ResponseEntity atualizarSubActivity(@RequestBody SubActivityDTO subActivityDTO){
        try{
            SubActivitys subActivity = ConverterUtils.convertTo(subActivityDTO, SubActivitys.class);
            subActivityService.salvarNovaSubAtividade(subActivity);
            return tryResponse();
        }catch (Exception e){
            return catchResponse();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletarSubActivity(@PathVariable("id") Long idSubActivity){
        try{
            subActivityService.removerSubAtividade(idSubActivity);
            return tryResponse();
        }catch (Exception e){
            return catchResponse();
        }
    }
}
