package compasso.challenge.backend.service.form;

import compasso.challenge.backend.model.Cidade;
import compasso.challenge.backend.model.Cliente;
import compasso.challenge.backend.repository.CidadeRepository;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ClienteForm {

    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    private Integer idade;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private String sexo;
    @NotNull
    @NotEmpty
    private String nomeCidade;

    public Cliente transform(CidadeRepository cidadeRepository) {
        Cidade cidade = (Cidade) cidadeRepository.findCidadesByNome(nomeCidade.toUpperCase()).get(0);
        return new Cliente(nome.toUpperCase(), sexo, dataNascimento, idade, cidade);
    }
}
