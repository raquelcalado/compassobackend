package compasso.challenge.backend.repository;

import java.util.List;

import compasso.challenge.backend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public List<Cliente> findClienteByNome(String nome);

}