package transicaoCntroller;

import com.bancoprojeto.banco.entities.Transacao;
import services.TransacaoService;
import Modelo.TransacaoModelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TransicaoController {
     @Autowired
    private TransacaoService transacaoService;
    
    @GetMapping("/transacoes")
    public Iterable<Transacao> listar(){
        return transacaoService.listar();
    }
    
    @PostMapping("/transacoes")
    public ResponseEntity<?> salvar (@RequestBody Transacao transacao){
        return transacaoService.salvar(transacao,"Salvar");
    }
    
    @PutMapping("/transacoes/{id}")
    public ResponseEntity<?> atualizar (@RequestBody Transacao transacao){
        return transacaoService.salvar(transacao,"Atualizar");
    }
    
    @DeleteMapping("/transacoes/{id}")
    public ResponseEntity<TransacaoModelo> deletar (@PathVariable Long id){
        return transacaoService.remover(id);
    }
}
