package compasso.challenge.backend.service;

import compasso.challenge.backend.model.Cidade;
import compasso.challenge.backend.repository.CidadeRepository;
import compasso.challenge.backend.service.dto.CidadeDto;
import compasso.challenge.backend.service.dto.EstadoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Service
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    public CidadeRepository cidadeRepository;

    @Override
    public ResponseEntity<CidadeDto> add(@RequestBody @Valid Cidade cidade,
                                         UriComponentsBuilder uriBuilder) {
        Cidade novaCidade = cidadeRepository.save(cidade);

        URI uri = uriBuilder.path("/cidades/{id}").buildAndExpand(novaCidade.getId()).toUri();
        return ResponseEntity.created(uri).body(new CidadeDto(novaCidade));
    }

    @Override
    public List<CidadeDto> searchForName(String nome) {
        List<Cidade> cidades = cidadeRepository.findAll();
        if (nome != null) {
            cidades = cidadeRepository.findCidadesByNome(nome.toUpperCase());
        }
        return CidadeDto.tranformInDTO(cidades);
    }

    @Override
    public List<?> searchForState(String state) {
        if (state == null) {
            List<Cidade> cidades = cidadeRepository.findAll();
            return EstadoDto.tranformInDTO(cidades);
        }else{
            List<Cidade> listOfCities = cidadeRepository.findCidadesByEstado(state.toUpperCase());
            return CidadeDto.tranformInDTO(listOfCities);
        }
    }
}
