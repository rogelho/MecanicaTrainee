package br.com.sg.trainee.mecanica.repository;

import br.com.sg.trainee.mecanica.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
