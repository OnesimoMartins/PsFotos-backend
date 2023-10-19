package com.isptec.psfotos.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("albums")
@RestController
public class AlbumController {


    @GetMapping("fotos")
    public String getFotosUrl(){
        System.out.println("testeee");
        return "test";
    }
}
