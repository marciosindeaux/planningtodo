package br.sindeaux.planningtod.planningtodo.service;

import br.sindeaux.planningtod.planningtodo.repository.SubActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubActivityService {
    @Autowired
    private SubActivityRepository subActivityRepository;
}
