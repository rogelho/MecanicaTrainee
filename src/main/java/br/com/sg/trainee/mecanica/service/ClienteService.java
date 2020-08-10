package br.com.sg.trainee.mecanica.service;

import br.com.sg.trainee.mecanica.domain.Cliente;
import br.com.sg.trainee.mecanica.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Cliente salvarCliente(Cliente cliente) {
        return this.repository.save(cliente);
    }

    @Transactional
    public Cliente buscarCliente(int id) {
        Optional<Cliente> clienteNoBanco = this.repository.findById(id);

        if (clienteNoBanco.isPresent()) {
            return clienteNoBanco.get();
        }

        return null;
    }

    @Transactional
    public List<Cliente> listarCliente(){
        return this.repository.findAll();
    }

    @Transactional
    public boolean deletarCliente(int id) {

        if (this.buscarCliente(id) != null ) {
            this.repository.deleteById(id);
            return true;
        }

        return false;
    }

}