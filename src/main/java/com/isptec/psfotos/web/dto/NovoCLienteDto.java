package com.isptec.psfotos.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class NovoCLienteDto {

    private String nome;
    private String password;

}
