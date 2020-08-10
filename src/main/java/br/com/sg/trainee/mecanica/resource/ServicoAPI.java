package br.com.sg.trainee.mecanica.resource;

import br.com.sg.trainee.mecanica.domain.Servico;
import br.com.sg.trainee.mecanica.service.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "servico")
public class ServicoAPI {
    private final ServicoService service;

    public ServicoAPI(ServicoService service) {
        this.service = service;
    }

    @PostMapping(path = "orçamento")
    public ResponseEntity salvarServico(@RequestBody Servico servico){
        return ResponseEntity.ok(service.salvarServico(servico));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity buscarServico(@PathVariable int id){
        return ResponseEntity.ok(service.buscarServico(id));
    }

    @GetMapping(path = "aprovar/{id}")
    public ResponseEntity aprovarOrcamento(@PathVariable int id){
        return ResponseEntity.ok(service.aprovarOrcamento(id));
    }

    @GetMapping(path = "iniciar/{id}")
    public ResponseEntity iniciarServico(@PathVariable int id){
        return ResponseEntity.ok(service.iniciarServico(id));
    }

    @GetMapping(path = "finalizar/{id}")
    public ResponseEntity encerrarServico(@PathVariable int id){
        return ResponseEntity.ok(service.encerrarServico(id));
    }

    @GetMapping(path = "listar")
    public ResponseEntity listarServico(){
        return  ResponseEntity.ok(service.listarServico());
    }

    @GetMapping(path = "listar/{veiculo}")
    public ResponseEntity listarPorVeiculos(@PathVariable int veiculo){
        return  ResponseEntity.ok(service.listarPorVeiculo(veiculo));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity deletarServico(@PathVariable int id){

        boolean foiDeletado = this.service.deletarServico(id);

        if (!foiDeletado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Ordem de Serviço deletada com sucesso!");
    }
}
