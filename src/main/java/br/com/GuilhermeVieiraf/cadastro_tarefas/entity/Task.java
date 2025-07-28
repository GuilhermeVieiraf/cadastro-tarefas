package br.com.GuilhermeVieiraf.cadastro_tarefas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "title", length = 100, nullable = false)
    private String title;
    @Column(name = "description", length = 500, nullable = false)
    private String description;
    @Column(name = "expiration_date", nullable = false)
    @Future
    private LocalDate expirationDate;
}
