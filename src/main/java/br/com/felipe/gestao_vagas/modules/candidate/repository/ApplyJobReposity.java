package br.com.felipe.gestao_vagas.modules.candidate.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipe.gestao_vagas.modules.candidate.entity.ApplyJobEntity;

public interface ApplyJobReposity extends JpaRepository<ApplyJobEntity, UUID>{
    
}
