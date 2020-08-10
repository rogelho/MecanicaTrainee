package br.com.sg.trainee.mecanica.service;

import br.com.sg.trainee.mecanica.domain.Item;
import br.com.sg.trainee.mecanica.domain.Servico;
import br.com.sg.trainee.mecanica.repository.ServicoRepository;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {
    private final ServicoRepository repository;

    public ServicoService(ServicoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Servico salvarServico(Servico servico) {

        BigDecimal valorTotal = BigDecimal.ZERO;

        for(Item item : servico.getItens()){
            valorTotal = valorTotal.add(item.getQuantidade().multiply(item.getValorUnidade()));
        }

        servico.setValorTotal(valorTotal);

        return this.repository.save(servico);
    }

    @Transactional
    public Servico aprovarOrcamento(int id) {

        Servico servico = this.buscarServico(id);

        servico.setOrcamentoAprovado(true);

        return this.repository.save(servico);
    }

    @Transactional
    public Servico iniciarServico(int id) {

        Servico servico = this.buscarServico(id);

        servico.setDataInicioServico(new Date());

        return this.repository.save(servico);
    }

    @Transactional
    public Servico encerrarServico(int id) {

        Servico servico = this.buscarServico(id);

        servico.setDataFimServico(new Date());

        return this.repository.save(servico);
    }

    @Transactional
    public Servico buscarServico(int id) {
        Optional<Servico> servicoNoBanco = this.repository.findById(id);

        if (servicoNoBanco.isPresent()) {
            return servicoNoBanco.get();
        }

        return null;
    }

    @Transactional
    public List<Servico> listarServico(){
        return this.repository.findAll();
    }

    @Transactional
    public List<Servico> listarPorVeiculo(int veiculo){
        return this.repository.findByVeiculo(veiculo);
    }

    @Transactional
    public boolean deletarServico(int id) {

        if (this.buscarServico(id) != null ) {
            this.repository.deleteById(id);
            return true;
        }

        return false;
    }

}
