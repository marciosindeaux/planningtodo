package br.sindeaux.planningtod.planningtodo.controller;

import br.sindeaux.planningtod.planningtodo.dto.base.ActivityDTO;
import br.sindeaux.planningtod.planningtodo.dto.root.ResponseDTO;
import br.sindeaux.planningtod.planningtodo.entity.Activity;
import br.sindeaux.planningtod.planningtodo.service.ActivityService;
import br.sindeaux.planningtod.planningtodo.utils.ConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("activity")
public class ActivityController implements AbstractController{

    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity cadastrarActivity(@RequestBody ActivityDTO activityDTO){
        try{
            Activity activity = ConverterUtils
                    .convertTo(activityDTO, Activity.class);

            activityService.salvarActivity(activity);
            return tryResponse();
        }catch (RuntimeException e){
            return catchResponse();
        }
    }

    @GetMapping("all")
    public ResponseEntity listarActivitys(){
        try{
            return tryResponse(
                    activityService.listarAtividades()
                            .stream()
                            .map(atividade -> ConverterUtils.convertTo(atividade, ActivityDTO.class))
            );
        }catch (RuntimeException e){
            return catchResponse();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity listarActivitys(@PathVariable(name = "id") Long idActivity){
        try{
            return tryResponse(activityService.listarPorId(idActivity));
        }catch (RuntimeException e){
            return catchResponse(e);
        }
    }
}
