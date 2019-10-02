package br.sindeaux.planningtod.planningtodo.controller;

import br.sindeaux.planningtod.planningtodo.dto.base.SubActivityDTO;
import br.sindeaux.planningtod.planningtodo.repository.SubActivityRepository;
import br.sindeaux.planningtod.planningtodo.service.SubActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sub-activity")
public class SubActivityController {

    @Autowired
    private SubActivityService subActivityService;

    @PostMapping
    public ResponseEntity cadastrarSubAtividade(@RequestBody SubActivityDTO subActivityDTO){
        try{}catch (Exception e){}
    }
}
