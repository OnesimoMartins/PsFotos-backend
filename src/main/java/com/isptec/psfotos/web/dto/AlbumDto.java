package com.isptec.psfotos.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumDto {

    @JsonProperty("id_cliente")
    private Integer idCliente;


    @JsonProperty("nome_album")
    private String nomeAlbum;
}
