package compasso.challenge.backend.controller;

import compasso.challenge.backend.model.Cidade;
import compasso.challenge.backend.service.CidadeService;
import compasso.challenge.backend.service.dto.CidadeDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @RequestMapping(value = { "/cidades" }, method = RequestMethod.GET)
    public List<CidadeDto> searchForName(String cidade){
        return cidadeService.searchForName(cidade);
    }

    @RequestMapping(value = {"/{estados}"}, method = RequestMethod.GET)
    public List<?> searchForState(String estado){
        return cidadeService.searchForState(estado);
    }

    @PostMapping({ "/cidades" })
    @Transactional
    public ResponseEntity<CidadeDto> add(@RequestBody @Valid Cidade cidade, UriComponentsBuilder uriBuilder) {
        return cidadeService.add(cidade, uriBuilder);
    }
}
