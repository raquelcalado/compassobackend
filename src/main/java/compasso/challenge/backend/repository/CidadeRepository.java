package compasso.challenge.backend.repository;

import java.util.List;

import compasso.challenge.backend.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    public List<Cidade> findCidadesByNome(String nome);

    public List<Cidade> findCidadesByEstado(String estado);

}
