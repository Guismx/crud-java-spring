package com.placeti.avaliacao.service;

import com.placeti.avaliacao.dto.CidadeDTO;
import com.placeti.avaliacao.model.Cidade;
import com.placeti.avaliacao.repository.CidadeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//------------------------------------------------------------------
/** Service usado para acessar os repositórios da aplicação */
//------------------------------------------------------------------
@Service
public class CidadeService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CidadeRepository cidadeRepository;
	//---------------------------------------------------------
	/** Método que busca uma cidade pelo seu ID */
	//---------------------------------------------------------
	public CidadeDTO pesquisarCidade(Long id) {
		Cidade cidade = this.cidadeRepository.findById(id).orElse(null);

		if (cidade == null) {
			return null;
		}
		return CidadeDTO.toDTO(cidade);
    }

	//---------------------------------------------------------
	/**
	 * Método que retorna todas as cidades cadastradas
	 */
	//---------------------------------------------------------
	public List<CidadeDTO> pesquisarCidades() {
		List<Cidade> lista = this.cidadeRepository.findAll();
		List<CidadeDTO> cidadeDTOs = new ArrayList<>();

		for (Cidade cidade : lista) {
			cidadeDTOs.add(CidadeDTO.toDTO(cidade));
		}

		return cidadeDTOs;
	}

	//----------------------------------------------------------
	/**
	 * Método chamado para incluir uma nova cidade
	 *
	 * @return
	 */
	//----------------------------------------------------------	
	public CidadeDTO incluirCidade(CidadeDTO dto) {
		Cidade cidade = new Cidade();
		cidade.setNome(dto.getNome());
		cidade.setUf(dto.getUf());
		cidade.setCapital(dto.getCapital());

		cidade = cidadeRepository.save(cidade);

		return CidadeDTO.toDTO(cidade);
	}

	//----------------------------------------------------------
	/**
	 * Método chamado para alterar os dados de uma cidade
	 *
	 * @return
	 */
	//----------------------------------------------------------
	public CidadeDTO alterarCidade(CidadeDTO dto) {
		Cidade cidade = cidadeRepository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

		cidade.setNome(dto.getNome());
		cidade.setUf(dto.getUf());
		cidade.setCapital(dto.getCapital());

		cidade = cidadeRepository.save(cidade);

		return CidadeDTO.toDTO(cidade);
	}

	//----------------------------------------------------------
	/**
	 * Método chamado para excluir uma cidade
	 *
	 * @return
	 */
	//----------------------------------------------------------
	public CidadeDTO excluirCidade(Long idCidade) {
		Cidade cidade = cidadeRepository.findById(idCidade).orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

		cidadeRepository.deleteById(idCidade);

		return CidadeDTO.toDTO(cidade);
	}
}
