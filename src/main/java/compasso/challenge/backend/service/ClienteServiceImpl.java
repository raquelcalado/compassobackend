package compasso.challenge.backend.service;

import compasso.challenge.backend.model.Cidade;
import compasso.challenge.backend.model.Cliente;
import compasso.challenge.backend.repository.CidadeRepository;
import compasso.challenge.backend.repository.ClienteRepository;
import compasso.challenge.backend.service.dto.ClienteDto;
import compasso.challenge.backend.service.form.ClienteForm;
import compasso.challenge.backend.service.form.UpdateClienteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public List<ClienteDto> searchForName(String nome) {
        List<Cliente> listOfClients = clienteRepository.findAll();
        if (nome != null) {
            listOfClients = clienteRepository.findClienteByNome(nome.toUpperCase());
        }
        return ClienteDto.tranformInDTO(listOfClients);
    }

    @Override
    public ResponseEntity<ClienteDto> searchForId(Long id) {
        Optional<Cliente> listOfClients = clienteRepository.findById(id);
        if (listOfClients.isPresent()) {
            return ResponseEntity.ok(new ClienteDto(listOfClients.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<ClienteDto> add(ClienteForm form, UriComponentsBuilder uriBuilder) {
        Cliente cliente = form.transform(cidadeRepository);
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDto(cliente));
    }

    @Override
    public ResponseEntity<ClienteDto> update(Long id, UpdateClienteForm form) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if(optional.isPresent()) {
            Cliente cliente = form.update(id, clienteRepository);
            return ResponseEntity.ok(new ClienteDto(cliente));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Cliente> c = clienteRepository.findById(id);
        if(c.isPresent()) {
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
