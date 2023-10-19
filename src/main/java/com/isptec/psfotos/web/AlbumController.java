package com.isptec.psfotos.web;

import com.isptec.psfotos.domain.domain.entity.Album;
import com.isptec.psfotos.domain.domain.entity.Cliente;
import com.isptec.psfotos.domain.domain.service.AlbumService;
import com.isptec.psfotos.web.dto.AlbumDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequestMapping("albums")
@RestController
@AllArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping("fotos")
    public String getFotosUrl(){
        System.out.println("testeee");
        return "test";
    }

    @PostMapping()
    public Album novoAlbum(@RequestBody AlbumDto dto){
        return albumService.novoAlbum(Album.builder()
                        .cliente(Cliente.builder()
                                .id(dto.getIdCliente())
                                .build())
                        .nome(dto.getNomeAlbum())
                .build());
    }


}
