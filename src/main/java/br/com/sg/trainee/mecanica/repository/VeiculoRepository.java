package br.com.sg.trainee.mecanica.repository;

import br.com.sg.trainee.mecanica.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    @Query(value = "SELECT * FROM VEICULO WHERE CLIENTE_ID = ?1", nativeQuery = true)
    List<Veiculo> findByCliente(int cliente);
}
