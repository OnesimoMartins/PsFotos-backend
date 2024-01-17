package com.isptec.psfotos.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.StringTokenizer;

@Getter
@Setter
public class ApiSearchFilter {

    private String campo;
    private String operacao;
    private String valor;

    public ApiSearchFilter(String value){

        var tokenizerCampos= new StringTokenizer(value,";");

        while (tokenizerCampos.hasMoreElements()){
               System.out.println(tokenizerCampos.nextToken());
        }
    }
}
