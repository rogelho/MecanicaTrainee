package br.com.sg.trainee.mecanica.resource;

import br.com.sg.trainee.mecanica.domain.Veiculo;
import br.com.sg.trainee.mecanica.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "veiculo")
public class VeiculoAPI {
    private final VeiculoService service;

    public VeiculoAPI(VeiculoService service) {
        this.service = service;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity salvarVeiculo(@RequestBody Veiculo veiculo){
        return ResponseEntity.ok(service.salvarVeiculo(veiculo));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity buscarVeiculo(@PathVariable int id){
        return ResponseEntity.ok(service.buscarVeiculo(id));
    }

    @GetMapping(path = "listar")
    public ResponseEntity listarVeiculos(){
        return  ResponseEntity.ok(service.listarVeiculo());
    }

    @GetMapping(path = "listar/{cliente}")
    public ResponseEntity listarPorCliente(@PathVariable int cliente){
        return  ResponseEntity.ok(service.listarPorCliente(cliente));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity deletarVeiculo(@PathVariable int id){

        boolean foiDeletado = this.service.deletarVeiculo(id);

        if (!foiDeletado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Veiculo deletado com sucesso!");
    }
}
