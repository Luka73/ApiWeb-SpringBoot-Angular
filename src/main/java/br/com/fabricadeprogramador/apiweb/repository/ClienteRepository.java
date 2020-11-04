package br.com.fabricadeprogramador.apiweb.repository;

import br.com.fabricadeprogramador.apiweb.model.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
