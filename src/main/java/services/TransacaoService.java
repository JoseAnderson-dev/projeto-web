package services;

import com.bancoprojeto.banco.entities.Transacao;
import repository.TransacaoRepository;
import Modelo.TransacaoModelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {
    
    @Autowired
    private TransacaoRepository transacaoRepository;


    @Autowired
    private TransacaoModelo transacaoModelo;

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

    public ResponseEntity<TransacaoModelo> remover(Long id) {
        transacaoRepository.deleteById(id);
        transacaoModelo.setMensagem("A Transação foi removida com sucesso.");
        return new ResponseEntity<TransacaoModelo>(transacaoModelo, HttpStatus.OK);
    }
}
