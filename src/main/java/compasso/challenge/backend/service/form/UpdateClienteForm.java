package compasso.challenge.backend.service.form;

import compasso.challenge.backend.model.Cliente;
import compasso.challenge.backend.repository.ClienteRepository;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UpdateClienteForm {
    @NotEmpty
    @NotNull
    public String nome;

    public Cliente update(Long id, ClienteRepository clienteRepository) {
        Cliente cliente = clienteRepository.getOne(id);
        cliente.setNome(this.nome.toUpperCase());
        return cliente;
    }
}
