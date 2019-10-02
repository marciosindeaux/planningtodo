package br.sindeaux.planningtod.planningtodo.service;

import br.sindeaux.planningtod.planningtodo.entity.SubActivitys;
import br.sindeaux.planningtod.planningtodo.repository.SubActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
public class SubActivityService {

    @Autowired
    private SubActivityRepository subActivityRepository;

    public void salvarNovaSubAtividade(SubActivitys subActivitys){
        subActivityRepository.save(subActivitys);
    }

    public List<SubActivitys> listarSubAtividadesDeAtividade(Long idActivity){
        return subActivityRepository.findAllByActivity_Id(idActivity);
    }
}
