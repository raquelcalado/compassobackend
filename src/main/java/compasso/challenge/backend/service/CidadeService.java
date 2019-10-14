package compasso.challenge.backend.service;

import compasso.challenge.backend.model.Cidade;
import compasso.challenge.backend.service.dto.CidadeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public interface CidadeService {

    public ResponseEntity<CidadeDto> add(Cidade cidade, UriComponentsBuilder uriBuilder);
    public List<CidadeDto> searchForName(String name);
    public List<?> searchForState(String estado);

}
