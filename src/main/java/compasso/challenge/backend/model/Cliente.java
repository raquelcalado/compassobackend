package compasso.challenge.backend.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sexo;
    private LocalDate dataNascimento;
    private int idade;
    @ManyToOne
    private Cidade cidade;

    public Cliente(String nome, String sexo, LocalDate dataNascimento, int idade, Cidade cidade) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.cidade = cidade;
    }
}
