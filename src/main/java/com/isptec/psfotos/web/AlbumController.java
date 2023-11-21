package com.isptec.psfotos.web;

import com.isptec.psfotos.domain.entity.Cliente;
import com.isptec.psfotos.domain.service.AlbumService;
import com.isptec.psfotos.domain.entity.Album;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.isptec.psfotos.web.dto.AlbumDto;
import org.springframework.web.multipart.MultipartFile;


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

    @PutMapping("{id}/imagem")
    public Boolean uploadImagem(@PathVariable Integer id, MultipartFile image){
        System.out.println("testeee");
        return true;
    }

    @PostMapping
    public Album novoAlbum(@RequestBody AlbumDto dto){
        return albumService.novoAlbum(
                Album.builder()
                        .cliente(Cliente.builder()
                                .id(dto.getIdCliente())
                                .build()
                        )
                        .nome(dto.getNomeAlbum())
                .build()
        );
    }


}
