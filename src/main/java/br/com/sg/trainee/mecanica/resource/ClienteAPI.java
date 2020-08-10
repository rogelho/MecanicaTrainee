package br.com.sg.trainee.mecanica.resource;

import br.com.sg.trainee.mecanica.domain.Cliente;
import br.com.sg.trainee.mecanica.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "cliente")
public class ClienteAPI {
    private final ClienteService service;

    public ClienteAPI(ClienteService service) {
        this.service = service;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity salvarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(service.salvarCliente(cliente));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity buscarCliente(@PathVariable int id){
        return ResponseEntity.ok(service.buscarCliente(id));
    }

    @GetMapping(path = "listar")
    public ResponseEntity listarClientes(){
        return  ResponseEntity.ok(service.listarCliente());
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity deletarCliente(@PathVariable int id){

        boolean foiDeletado = this.service.deletarCliente(id);

        if (!foiDeletado) {
            return ResponseEntity.ok("Cliente não encontrado!");
        }

        return ResponseEntity.ok("Cliente deletado com sucesso!");
    }
}