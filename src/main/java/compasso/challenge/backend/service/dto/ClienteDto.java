package compasso.challenge.backend.service.dto;

import compasso.challenge.backend.model.Cliente;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ClienteDto {

	private Long id;
	private String nome;
	private Integer idade;
	private LocalDate dataNascimento;
	private String sexo;
	private String cidade;


	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.idade = cliente.getIdade();
		this.dataNascimento = cliente.getDataNascimento();
		this.sexo = cliente.getSexo();
		this.cidade = cliente.getCidade().getNome();
	}

	public static List<ClienteDto> tranformInDTO(List<Cliente> clients) {
		return clients.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
}
