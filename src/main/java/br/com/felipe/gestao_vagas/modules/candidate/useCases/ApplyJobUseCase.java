package br.com.felipe.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.gestao_vagas.exceptions.JobNotFoundException;
import br.com.felipe.gestao_vagas.exceptions.UserNotFoundException;
import br.com.felipe.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.felipe.gestao_vagas.modules.candidate.entity.ApplyJobEntity;
import br.com.felipe.gestao_vagas.modules.candidate.repository.ApplyJobReposity;
import br.com.felipe.gestao_vagas.modules.company.repositories.JobsRepository;

@Service
public class ApplyJobUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private ApplyJobReposity applyJobReposity;

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob){

        //validar se candidato existe
        this.candidateRepository.findById(idCandidate)
    .orElseThrow(()->{
        throw new UserNotFoundException();
    });

        //validar se a vaga existe
        this.jobsRepository.findById(idJob)
        .orElseThrow(()->{
            throw new JobNotFoundException();
        });

        //candidato se inscreve na vaga
        var applyJob = ApplyJobEntity.builder()
            .candidateId(idCandidate)
            .jobId(idJob).build();

        applyJob = applyJobReposity.save(applyJob);
        return applyJob;
    }
}
