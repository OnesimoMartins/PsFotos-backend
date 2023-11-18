package com.isptec.psfotos.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
public class ClienteDto {

    @NotNull
    private String nome;

    @NotNull
    private String email;
    @NotNull
    private String password;
}
