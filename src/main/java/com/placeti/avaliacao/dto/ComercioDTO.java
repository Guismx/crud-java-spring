package com.placeti.avaliacao.dto;

import com.placeti.avaliacao.model.Comercio;
import com.placeti.avaliacao.model.TipoComercio;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComercioDTO {

    private Long id;
    private String nomeComercio;
    private String nomeResponsavel;
    private TipoComercio tipoComercio;
    private Long cidadeId;

    public static ComercioDTO toDTO(Comercio comercio) {
        ComercioDTO comercioDTO = new ComercioDTO();
        comercioDTO.setId(comercio.getId());
        comercioDTO.setNomeComercio(comercio.getNomeComercio());
        comercioDTO.setNomeResponsavel(comercio.getNomeResponsavel());
        comercioDTO.setTipoComercio(comercio.getTipoComercio());
        comercioDTO.setCidadeId(comercio.getCidade().getId());
        return comercioDTO;
    }
}
