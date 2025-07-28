package br.com.GuilhermeVieiraf.cadastro_tarefas.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDTO(
        UUID id,
        @NotBlank
        @Size(min = 3, max = 100)
        String title,
        @Size(max = 500)
        String description,
        @Future
        @NotNull
        LocalDate expirationDate) {


}
