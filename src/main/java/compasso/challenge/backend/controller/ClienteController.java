package compasso.challenge.backend.controller;

import compasso.challenge.backend.model.Cliente;
import compasso.challenge.backend.repository.CidadeRepository;
import compasso.challenge.backend.repository.ClienteRepository;
import compasso.challenge.backend.service.ClienteService;
import compasso.challenge.backend.service.dto.ClienteDto;
import compasso.challenge.backend.service.form.ClienteForm;
import compasso.challenge.backend.service.form.UpdateClienteForm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping({ "/clientes" })
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDto> searchForName(String nome){
        return clienteService.searchForName(nome);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClienteDto> searchForId(@PathVariable Long id){
        return clienteService.searchForId(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDto> add(@RequestBody @Valid ClienteForm form,
                                                       UriComponentsBuilder uriBuilder) {
        return clienteService.add(form, uriBuilder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ClienteDto> update(@PathVariable Long id, @RequestBody @Valid UpdateClienteForm form) {
        return clienteService.update(id, form);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        clienteService.delete(id);
    }

}
