package br.com.haan.ct.services;

import br.com.haan.ct.entities.Transacao;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    // aula do dia 10/08
    @Autowired
    private RespostaModelo respostaModelo;

    public Iterable<Transacao> listar() {
        return transacaoRepository.findAll();
    }

    public ResponseEntity<?> salvar(Transacao transacao, String acao) {
        if (acao.equals("Salvar")) {
            return new ResponseEntity<Transacao>(transacaoRepository.save(transacao), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Transacao>(transacaoRepository.save(transacao), HttpStatus.OK);
        }
    }

    public ResponseEntity<RespostaModelo> remover(Long id) {
        transacaoRepository.deleteById(id);
        respostaModelo.setMensagem("a transacao foi removido com sucesso.");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
}
