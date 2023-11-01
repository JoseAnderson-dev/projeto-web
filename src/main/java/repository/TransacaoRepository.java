package repository;

import com.bancoprojeto.banco.entities.Transacao;
import org.springframework.data.repository.CrudRepository; 

public interface TransacaoRepository extends CrudRepository<Transacao,Long >{
    
}
