package br.com.felipe.gestao_vagas.modules.candidate.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.gestao_vagas.modules.company.entities.JobEntity;
import br.com.felipe.gestao_vagas.modules.company.repositories.JobsRepository;

@Service
public class ListAllJobsByFilterUseCase {
    
    @Autowired
    private JobsRepository jobsRepository;


    public List<JobEntity> execute(String filter){
        return this.jobsRepository.findByDescriptionContainingIgnoreCase(filter);
    }
}
