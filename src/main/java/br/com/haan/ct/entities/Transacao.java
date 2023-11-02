package br.com.haan.ct.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;

@Entity
@Data
public class Transacao {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nomeLoja;
    private int valor;
    private String cpf;
    private int cartao;
    private String hora;
    private String data;
    private String comentario;
    
  
    
}
