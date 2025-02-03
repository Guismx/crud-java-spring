package com.placeti.avaliacao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Comercio")
public class Comercio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME_COMERCIO", length = 100, nullable = false)
    private String nomeComercio;

    @Column(name = "NOME_RESPONSAVEL", length = 100, nullable = false)
    private String nomeResponsavel;

    @Column(name = "TIPO_COMERCIO", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoComercio tipoComercio;

    @ManyToOne
    @JoinColumn(name = "CIDADE_ID", nullable = false)
    private Cidade cidade;
}

