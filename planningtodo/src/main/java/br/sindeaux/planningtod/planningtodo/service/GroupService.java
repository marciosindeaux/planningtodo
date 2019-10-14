package br.sindeaux.planningtod.planningtodo.service;

import br.sindeaux.planningtod.planningtodo.entity.Activity;
import br.sindeaux.planningtod.planningtodo.entity.Group;
import br.sindeaux.planningtod.planningtodo.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public void salvarGroup(Group group){
        groupRepository.save(group);
    }

    public List<Group> listarGrupos(){
        return groupRepository.findAll();
    }

    public List<Activity> listarAtividadesDeGrupo(Long idGrupo){
        Group grupo = Objects.requireNonNull(groupRepository.findById(idGrupo).get());
        return grupo.getActivityList();
    }

    public void deletarUm(Long idGrupo){
        groupRepository.deleteById(idGrupo);
    }
}
