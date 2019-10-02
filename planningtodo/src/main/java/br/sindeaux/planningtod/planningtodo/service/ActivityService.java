package br.sindeaux.planningtod.planningtodo.service;

import br.sindeaux.planningtod.planningtodo.entity.Activity;
import br.sindeaux.planningtod.planningtodo.entity.SubActivitys;
import br.sindeaux.planningtod.planningtodo.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(rollbackOn = Exception.class)
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private SubActivityService subActivityService;

    public void salvarActivity(Activity activity){
        activityRepository.save(activity);
    }

    public List<Activity> listarAtividades(){
        return activityRepository.findAll();
    }

    public Activity listarPorId(Long id){
        return activityRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Elemento não encontrado"));
    }

    public List<SubActivitys> listarSubAtividadesDeAtividade(Long id){
        List<SubActivitys> subAtividades = subActivityService.listarSubAtividadesDeAtividade(id);
        if(subAtividades.isEmpty()){
            throw new NoSuchElementException("Nenhum elemento encontrado");
        }
        return  subAtividades;
    }
}
