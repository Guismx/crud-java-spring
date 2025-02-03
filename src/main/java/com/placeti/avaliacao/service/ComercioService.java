package com.placeti.avaliacao.service;

import com.placeti.avaliacao.dto.ComercioDTO;
import com.placeti.avaliacao.model.Cidade;
import com.placeti.avaliacao.model.Comercio;
import com.placeti.avaliacao.repository.CidadeRepository;
import com.placeti.avaliacao.repository.ComercioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComercioService {

    @Autowired
    private ComercioRepository comercioRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public ComercioDTO pesquisarComercio(Long id) {
        Comercio comercio = comercioRepository.findById(id).orElse(null);

        if (comercio == null) {
            return null;
        }
        return ComercioDTO.toDTO(comercio);
    }

    public List<ComercioDTO> pesquisarComercios() {
        List<Comercio> lista = comercioRepository.findAll();
        List<ComercioDTO> comercioDTOs = new ArrayList<>();

        for (Comercio comercio : lista) {
            comercioDTOs.add(ComercioDTO.toDTO(comercio));
        }

        return comercioDTOs;
    }

    public ComercioDTO incluirComercio(ComercioDTO dto) {
        Cidade cidade = cidadeRepository.findById(dto.getCidadeId()).orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

        Comercio comercio = new Comercio();
        comercio.setNomeComercio(dto.getNomeComercio());
        comercio.setNomeResponsavel(dto.getNomeResponsavel());
        comercio.setTipoComercio(dto.getTipoComercio());
        comercio.setCidade(cidade);

        comercio = comercioRepository.save(comercio);

        return ComercioDTO.toDTO(comercio);
    }

    public ComercioDTO alterarComercio(ComercioDTO dto) {
        Comercio comercio = comercioRepository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("Comercio não encontrado"));

        Cidade cidade = cidadeRepository.findById(dto.getCidadeId()).orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

        comercio.setNomeComercio(dto.getNomeComercio());
        comercio.setNomeResponsavel(dto.getNomeResponsavel());
        comercio.setTipoComercio(dto.getTipoComercio());
        comercio.setCidade(cidade);

        comercio = comercioRepository.save(comercio);

        return ComercioDTO.toDTO(comercio);
    }

    public ComercioDTO excluirComercio(Long id) {
        Comercio comercio = comercioRepository.findById(id).orElseThrow(() -> new RuntimeException("Comercio não encontrado"));

        comercioRepository.deleteById(id);

        return ComercioDTO.toDTO(comercio);
    }
}
