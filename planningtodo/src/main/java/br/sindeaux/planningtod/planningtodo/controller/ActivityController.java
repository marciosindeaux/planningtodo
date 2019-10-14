package br.sindeaux.planningtod.planningtodo.controller;

import br.sindeaux.planningtod.planningtodo.dto.base.ActivityDTO;
import br.sindeaux.planningtod.planningtodo.dto.base.SubActivityDTO;
import br.sindeaux.planningtod.planningtodo.entity.Activity;
import br.sindeaux.planningtod.planningtodo.service.ActivityService;
import br.sindeaux.planningtod.planningtodo.utils.ConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("activity")
public class ActivityController implements AbstractController{

    @Autowired
    private ActivityService activityService;

    @DeleteMapping("{id}")
    public ResponseEntity excluirActivity(@PathVariable("id") Long idActivity){
        try {
            activityService.deletarAtividade(idActivity);
            return tryResponse();
        }catch (Exception e){
            return catchResponse();
        }
    }

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

    @PutMapping
    public ResponseEntity atualizarDadosActivity(@RequestBody ActivityDTO activityDTO){
        try{
            Activity activity = ConverterUtils
                    .convertTo(activityDTO, Activity.class);
            activityService.salvarActivity(activity);
            return tryResponse();
        }catch (Exception e){
            return catchResponse();
        }
    }

    @GetMapping("listar-todos")
    public ResponseEntity listarActivitys(){
        try{
            return tryResponse(
                    activityService.listarAtividades()
                            .stream()
                            .map(atividade -> ConverterUtils.convertTo(atividade, ActivityDTO.class))
                            .collect(Collectors.toList()));
        }catch (RuntimeException e){
            return catchResponse();
        }
    }

    @GetMapping("listar-pendente")
    public ResponseEntity listarActivitysPendentes(){
        try {
            return tryResponse(activityService.listarPendentes(true)
                    .stream()
                    .map(atividade -> ConverterUtils.convertTo(atividade, ActivityDTO.class))
                    .collect(Collectors.toList()));
        }catch (Exception e){
            return catchResponse();
        }
    }

    @GetMapping("listar-realizados")
    public ResponseEntity listarActivitysRealizadas(){
        try {
            return tryResponse(activityService.listarPendentes(false)
                    .stream()
                    .map(atividade -> ConverterUtils.convertTo(atividade, ActivityDTO.class))
                    .collect(Collectors.toList()));
        }catch (Exception e){
            return catchResponse();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity listarActivitys(@PathVariable("id") Long idActivity){
        try{
            return tryResponse(ConverterUtils.convertTo(activityService.listarPorId(idActivity), Activity.class));
        }catch (RuntimeException e){
            return catchResponse(e);
        }
    }

    @GetMapping("{id}/sub-activitys")
    public ResponseEntity listarSubAtividadesDeAtividade(@PathVariable("id") Long idActivity){
        try {
            return tryResponse(activityService.listarSubAtividadesDeAtividade(idActivity).stream()
                    .map(subAtividade -> ConverterUtils.convertTo(subAtividade, SubActivityDTO.class))
                    .collect(Collectors.toList()));
        }catch (NoSuchElementException e){
            return catchResponse(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
