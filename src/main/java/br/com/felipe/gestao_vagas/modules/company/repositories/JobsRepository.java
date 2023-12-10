package br.com.felipe.gestao_vagas.modules.company.repositories;

import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipe.gestao_vagas.modules.company.entities.JobEntity;

public interface JobsRepository extends JpaRepository<JobEntity, UUID> {
    
    List<JobEntity> findByDescriptionContainingIgnoreCase(String filter);
}
