package br.com.felipe.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.gestao_vagas.exceptions.JobNotFoundException;
import br.com.felipe.gestao_vagas.exceptions.UserNotFoundException;
import br.com.felipe.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.felipe.gestao_vagas.modules.company.repositories.JobsRepository;

@Service
public class ApplyJobUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobsRepository jobsRepository;

    public void execute(UUID idCandidate, UUID idJob){

        this.candidateRepository.findById(idCandidate)
    .orElseThrow(()->{
        throw new UserNotFoundException();
    });

        this.jobsRepository.findById(idJob)
        .orElseThrow(()->{
            throw new JobNotFoundException();
        });

    }
}
