package br.com.sg.trainee.mecanica.service;

import br.com.sg.trainee.mecanica.domain.Veiculo;
import br.com.sg.trainee.mecanica.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Veiculo salvarVeiculo(Veiculo veiculo) {
        return this.repository.save(veiculo);
    }

    @Transactional
    public Veiculo buscarVeiculo(int id) {
        Optional<Veiculo> veiculoNoBanco = this.repository.findById(id);

        if (veiculoNoBanco.isPresent()) {
            return veiculoNoBanco.get();
        }

        return null;
    }

    @Transactional
    public List<Veiculo> listarVeiculo(){
        return this.repository.findAll();
    }

    @Transactional
    public List<Veiculo> listarPorCliente(int cliente){
        return this.repository.findByCliente(cliente);
    }

    @Transactional
    public boolean deletarVeiculo(int id) {

        if (this.buscarVeiculo(id) != null) {
            this.repository.deleteById(id);

            return true;
        }

        return false;
    }

}