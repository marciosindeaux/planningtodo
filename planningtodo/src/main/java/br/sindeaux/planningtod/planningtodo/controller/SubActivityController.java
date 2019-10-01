package br.sindeaux.planningtod.planningtodo.controller;

import br.sindeaux.planningtod.planningtodo.repository.SubActivityRepository;
import br.sindeaux.planningtod.planningtodo.service.SubActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sub-activity")
public class SubActivityController {

    @Autowired
    private SubActivityService subActivityService;
}
