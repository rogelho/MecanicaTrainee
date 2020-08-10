package br.com.sg.trainee.mecanica.repository;

import br.com.sg.trainee.mecanica.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
