package br.sindeaux.planningtod.planningtodo.service;

import br.sindeaux.planningtod.planningtodo.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;
}
