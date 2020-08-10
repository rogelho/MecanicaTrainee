package br.com.sg.trainee.mecanica.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Veiculo {
    @Id
    @GeneratedValue
    private int id;
    private String placa;
    private String cor;
    private String modelo;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private String motor;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
