package br.sindeaux.planningtod.planningtodo.controller;

import br.sindeaux.planningtod.planningtodo.dto.base.GroupDTO;
import br.sindeaux.planningtod.planningtodo.entity.Activity;
import br.sindeaux.planningtod.planningtodo.entity.Group;
import br.sindeaux.planningtod.planningtodo.service.GroupService;
import br.sindeaux.planningtod.planningtodo.utils.ConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("group")
public class GroupController implements AbstractController{

    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity cadastrarGrupo(@RequestBody GroupDTO groupDTO){
        try{
            Group group = ConverterUtils.convertTo(groupDTO, Group.class);
            groupService.salvarGroup(group);
            return tryResponse();
        }catch (Exception e){
            return catchResponse();
        }
    }

    @GetMapping
    public ResponseEntity listarGrupos(){
        try {
            return tryResponse(groupService.listarGrupos()
                    .stream()
                    .map((grupo) -> ConverterUtils.convertTo(grupo, GroupDTO.class))
                    .collect(Collectors.toList())
            );
        }catch (Exception e){
            return catchResponse();
        }
    }

    @GetMapping("{id}/activity")
    public ResponseEntity atividadesDoGrupo(@PathVariable("id") Long idGrupo){
        try{
            return  tryResponse(groupService.listarAtividadesDeGrupo(idGrupo)
                    .stream()
                    .map((activity) -> ConverterUtils.convertTo(activity, Activity.class))
                    .collect(Collectors.toList())
            );
        }catch (Exception e){
            return catchResponse();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletarGrupo(@PathVariable("id") Long idGrupo){
        try{
            groupService.deletarUm(idGrupo);
            return tryResponse();
        }catch (Exception e){
            return catchResponse();
        }
    }
}
