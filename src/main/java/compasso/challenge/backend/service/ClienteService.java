package compasso.challenge.backend.service;

import compasso.challenge.backend.model.Cliente;
import compasso.challenge.backend.service.dto.ClienteDto;
import compasso.challenge.backend.service.form.ClienteForm;
import compasso.challenge.backend.service.form.UpdateClienteForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public interface ClienteService {

    public ResponseEntity<ClienteDto> add(ClienteForm form, UriComponentsBuilder uriBuilder);
    public List<ClienteDto> searchForName(String nome);
    public ResponseEntity<ClienteDto> searchForId(Long id);
    public ResponseEntity<ClienteDto> update(Long id, UpdateClienteForm form);
    public ResponseEntity<?> delete(Long id);

}
