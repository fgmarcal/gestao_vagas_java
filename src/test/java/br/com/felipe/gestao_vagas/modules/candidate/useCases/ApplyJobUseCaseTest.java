package br.com.felipe.gestao_vagas.modules.candidate.useCases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.felipe.gestao_vagas.exceptions.JobNotFoundException;
import br.com.felipe.gestao_vagas.exceptions.UserNotFoundException;
import br.com.felipe.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.felipe.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.felipe.gestao_vagas.modules.candidate.entity.ApplyJobEntity;
import br.com.felipe.gestao_vagas.modules.candidate.repository.ApplyJobReposity;
import br.com.felipe.gestao_vagas.modules.company.entities.JobEntity;
import br.com.felipe.gestao_vagas.modules.company.repositories.JobsRepository;

@ExtendWith(MockitoExtension.class)
public class ApplyJobUseCaseTest {

    @InjectMocks
    private ApplyJobUseCase applyJobUseCase;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobsRepository jobsRepository;

    @Mock
    private ApplyJobReposity applyJobReposity;
    
    @Test
    @DisplayName("Should not be able to apply for job with candidate not found")
    public void should_not_be_able_to_apply_job_with_candidate_not_found(){

        try {
            applyJobUseCase.execute(null, null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(UserNotFoundException.class);
        }
    }

    @Test
    public void should_not_be_able_to_apply_job_with_job_not_found(){

        var idCandidate = UUID.randomUUID();

        var candidate = new CandidateEntity();

        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(candidate));

        try {
            applyJobUseCase.execute(idCandidate, null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(JobNotFoundException.class);
        }
    }

    @Test
    public void should_be_able_to_create_a_new_applyjob(){
        var idCandidate = UUID.randomUUID();
        var idJob = UUID.randomUUID();

        var applyJob = ApplyJobEntity.builder().candidateId(idCandidate)
        .jobId(idJob)
        .build();

        var applyJobCreated = ApplyJobEntity.builder().id(UUID.randomUUID()).build();

        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(new CandidateEntity()));
        when(jobsRepository.findById(idJob)).thenReturn(Optional.of(new JobEntity()));

        when(applyJobReposity.save(applyJob)).thenReturn(applyJobCreated);

        var result = applyJobUseCase.execute(idCandidate, idJob);

        assertThat(result).hasFieldOrProperty("id");
        assertNotNull(result.getId());
    }
}
