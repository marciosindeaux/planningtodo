package br.sindeaux.planningtod.planningtodo.service;

import br.sindeaux.planningtod.planningtodo.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;
}
