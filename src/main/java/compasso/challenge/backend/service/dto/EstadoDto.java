package compasso.challenge.backend.service.dto;

import compasso.challenge.backend.model.Cidade;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class EstadoDto {
    private String estado;

    public EstadoDto(Cidade cidade) {
        this.estado = cidade.getEstado();
    }

    public static List<EstadoDto> tranformInDTO(List<Cidade> cidades) {
        return cidades.stream().map(EstadoDto::new).collect(Collectors.toList());
    }
}
