package br.com.sg.trainee.mecanica.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue
    private int id;
    private String descricao;
    private BigDecimal quantidade = BigDecimal.ZERO;
    private BigDecimal valorUnidade = BigDecimal.ZERO;
}
