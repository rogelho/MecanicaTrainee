package br.com.sg.trainee.mecanica.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Servico {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;
    private Date dataOrcamento = new Date();
    private boolean orcamentoAprovado = false;
    private Date dataInicioServico;
    private Date dataFimServico;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "servico_id")
    private List<Item> itens;
    private BigDecimal valorTotal = BigDecimal.ZERO;
}
