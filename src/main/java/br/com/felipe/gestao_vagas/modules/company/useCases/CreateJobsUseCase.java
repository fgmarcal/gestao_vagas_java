package br.com.felipe.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.gestao_vagas.modules.company.entities.JobEntity;
import br.com.felipe.gestao_vagas.modules.company.repositories.JobsRepository;

@Service
public class CreateJobsUseCase {
    
    @Autowired
    private JobsRepository jobsRepository;

    public JobEntity execute(JobEntity jobEntity){
        return this.jobsRepository.save(jobEntity);
    }
}
