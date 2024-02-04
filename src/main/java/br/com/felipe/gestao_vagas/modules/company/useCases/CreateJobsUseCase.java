package br.com.felipe.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.gestao_vagas.exceptions.CompanyNotFoundException;
import br.com.felipe.gestao_vagas.modules.company.entities.JobEntity;
import br.com.felipe.gestao_vagas.modules.company.repositories.CompanyRepository;
import br.com.felipe.gestao_vagas.modules.company.repositories.JobsRepository;

@Service
public class CreateJobsUseCase {
    
    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity jobEntity){
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(()->{
            throw new CompanyNotFoundException();
        });
        return this.jobsRepository.save(jobEntity);
    }
}
