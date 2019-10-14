package compasso.challenge.backend.service.dto;

import compasso.challenge.backend.model.Cidade;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CidadeDto {

	private Long id;
	private String cidade;
	private String estado;

	public CidadeDto(Cidade cidade) {
		this.id = cidade.getId();
		this.cidade = cidade.getNome();
		this.estado = cidade.getEstado();
	}

	public static List<CidadeDto> tranformInDTO(List<Cidade> cidades) {
		return cidades.stream().map(CidadeDto::new).collect(Collectors.toList());
	}
}
