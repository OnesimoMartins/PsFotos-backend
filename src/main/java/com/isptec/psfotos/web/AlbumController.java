package com.isptec.psfotos.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("albums")
public class AlbumController {


    @GetMapping("fotos")
    public String getFotosUrl(){
        return "test";
    }
}
