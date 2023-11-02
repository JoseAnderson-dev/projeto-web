package br.com.haan.ct.controllers;

import br.com.haan.ct.entities.Transacao;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.services.TransacaoService;
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

public class TransacaoController {
    
    
    @Autowired
    private TransacaoService transacaoService;
    
    @GetMapping("/transacao")
    public Iterable<Transacao> listar(){
        return transacaoService.listar();
    }
    
    @PostMapping("/transacao")
    public ResponseEntity<?> salvar (@RequestBody Transacao transacao){
        return transacaoService.salvar(transacao,"Salvar");
    }
    
    @PutMapping("/transacao/{id}")
    public ResponseEntity<?> atualizar (@RequestBody Transacao transacao){
        return transacaoService.salvar(transacao,"Atualizar");
    }
    
    @DeleteMapping("/transacao/{id}")
    public ResponseEntity<RespostaModelo> deletar (@PathVariable Long id){
        return transacaoService.remover(id);
    }
}
