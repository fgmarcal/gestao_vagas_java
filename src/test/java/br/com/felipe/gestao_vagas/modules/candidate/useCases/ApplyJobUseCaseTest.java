package br.com.felipe.gestao_vagas.modules.candidate.useCases;

import static org.assertj.core.api.Assertions.assertThat;
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
import br.com.felipe.gestao_vagas.modules.company.repositories.JobsRepository;

@ExtendWith(MockitoExtension.class)
public class ApplyJobUseCaseTest {

    @InjectMocks
    private ApplyJobUseCase applyJobUseCase;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobsRepository jobsRepository;
    
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
}