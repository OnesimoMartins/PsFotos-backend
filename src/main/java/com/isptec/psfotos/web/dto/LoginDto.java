package com.isptec.psfotos.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
public class LoginDto {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
