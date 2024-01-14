package br.com.felipe.gestao_vagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(description = "Nome do candidato", example = "José da Silva", requiredMode = RequiredMode.REQUIRED)
    private String name;

    @NotBlank()
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaços")
    @Schema(description = "Username do candidato", example = "josesilva", requiredMode = RequiredMode.REQUIRED)
    private String username;

    @Email(message = "O campo [e-mail] deve conter um email válido")
    @Schema(description ="E-mail do candidato", example = "jose@mail.com", requiredMode = RequiredMode.REQUIRED)
    private String email;
    @Length(min = 10, max = 100, message = "O campo [password] deve possuir uma senha entre 10 e 100 caracteres")
    @Schema(description = "Senha do candidato", example = "passwd@1234", minLength = 10, maxLength = 100, requiredMode = RequiredMode.REQUIRED)
    private String password;
    @Schema(description = "Breve descrição do candidato", example = "Desenvolvedor Java", requiredMode = RequiredMode.REQUIRED)
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
