package com.placeti.avaliacao.controller;

import com.placeti.avaliacao.dto.CidadeDTO;
import com.placeti.avaliacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Endpoint para consultar e manter cidades */
//--------------------------------------------------
@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;
	//----------------------------------------------------------
	/** Endpoint que retorna uma cidade conforme seu ID */
	//----------------------------------------------------------
	@GetMapping("/buscarPeloId/{id}")
	public ResponseEntity<CidadeDTO> buscarPeloId(@PathVariable Long id) {
		// TODO: Responde GET em http://localhost:8080/placeti/cidades/1
		try {
			CidadeDTO cidade = this.cidadeService.pesquisarCidade(id);
			return new ResponseEntity<>(cidade, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	//----------------------------------------------------------
	/** Endpoint que retorna todas as cidades cadastradas */
	//----------------------------------------------------------
	@GetMapping()
	public ResponseEntity<List<CidadeDTO>> pesquisarCidades() {
		// TODO: Responde GET em http://localhost:8080/placeti/cidades
		try {
			List<CidadeDTO> cidades = this.cidadeService.pesquisarCidades();
			return new ResponseEntity<>(cidades, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	//----------------------------------------------------------
	/** Endpoint para incluir nova cidade */
	//----------------------------------------------------------
	@PostMapping()
	public ResponseEntity<CidadeDTO> incluirCidade(@RequestBody CidadeDTO cidadeDto) {
		//	TODO: Responde POST em http://localhost:8080/placeti/cidades
		//	Envia JSON no body:
		//	{
		//	 	"nome": "Florianópolis",
		//	  	"uf": "SC",
		//	   	"capital": true
		//	}
		try {
			CidadeDTO cidade = this.cidadeService.incluirCidade(cidadeDto);
			return new ResponseEntity<>(cidade, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	//----------------------------------------------------------
	/** Endpoint para alterar cidade */
	//----------------------------------------------------------
	@PutMapping()
	public ResponseEntity<CidadeDTO> alterarCidade(@RequestBody CidadeDTO cidadeDto) {
		// TODO: Responde PUT em http://localhost:8080/placeti/cidades
		//   Envia JSON no body:
		//   {
		//     "id": 11,
		//     "nome": "Blumenau",
		//     "uf": "SC",
		//     "capital": false
		//   }
		try {
			CidadeDTO cidade = this.cidadeService.alterarCidade(cidadeDto);
			return new ResponseEntity<>(cidadeDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	//----------------------------------------------------------
	/** Endpoint para excluir uma cidade */
	//----------------------------------------------------------
	@DeleteMapping("/{idCidade}")
	public ResponseEntity<Long> excluirCidade(@PathVariable Long idCidade) {
		// Responde DELETE em http://localhost:8080/placeti/cidades/{idCidade}
		try {
			CidadeDTO cidade = this.cidadeService.excluirCidade(idCidade);
			return new ResponseEntity<>(idCidade, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}

//--------------------------------------------------

