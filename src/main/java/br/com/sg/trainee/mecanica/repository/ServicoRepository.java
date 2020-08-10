package br.com.sg.trainee.mecanica.repository;

import br.com.sg.trainee.mecanica.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    @Query(value = "SELECT * FROM SERVICO WHERE VEICULO_ID = ?1", nativeQuery = true)
    List<Servico> findByVeiculo(int veiculo);
}
