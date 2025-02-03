package com.placeti.avaliacao.controller;

import com.placeti.avaliacao.dto.ComercioDTO;
import com.placeti.avaliacao.service.ComercioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comercios")
public class ComercioController {

    @Autowired
    private ComercioService comercioService;

    @GetMapping("/buscarPeloId/{id}")
    public ResponseEntity<ComercioDTO> buscarPeloId(@PathVariable Long id) {
        try {
            ComercioDTO comercio = this.comercioService.pesquisarComercio(id);
            return new ResponseEntity<>(comercio, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<List<ComercioDTO>> pesquisarComercios() {
        try {
            List<ComercioDTO> comercios = this.comercioService.pesquisarComercios();
            return new ResponseEntity<>(comercios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<ComercioDTO> incluirComercio(@RequestBody ComercioDTO comercioDto) {
        try {
            ComercioDTO comercio = this.comercioService.incluirComercio(comercioDto);
            return new ResponseEntity<>(comercio, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<ComercioDTO> alterarComercio(@RequestBody ComercioDTO comercioDto) {
        try {
            ComercioDTO comercio = this.comercioService.alterarComercio(comercioDto);
            return new ResponseEntity<>(comercioDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> excluirComercio(@PathVariable Long id) {
        try {
            ComercioDTO comercio = this.comercioService.excluirComercio(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
