package br.com.haan.ct.repositories;

import br.com.haan.ct.entities.Transacao;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoRepository extends CrudRepository<Transacao,Long >{
    
}
