package com.isptec.psfotos.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@ToString
public class ClienteDto {

    @NotNull
    private String nome;

    @NotNull
    private String email;
    @NotNull
    private String password;
}
