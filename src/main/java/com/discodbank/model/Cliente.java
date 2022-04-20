package com.discodbank.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nome;
    private Long cpf;

}
