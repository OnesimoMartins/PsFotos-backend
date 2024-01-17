package com.isptec.psfotos.domain.service;

import com.isptec.psfotos.domain.entity.Album;
import com.isptec.psfotos.domain.repository.AlbumRepository;
import com.isptec.psfotos.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final ClienteRepository clienteRepository;
//    private final DropBoxService dropBoxService;

    public Album novoAlbum(Album album){
//        album.setCatalogo(dropBoxService.criarNovoCatalogo());
        return albumRepository.save(album);
    }


    public Album adicionarAmigo(Integer idAlbum, Integer idAmigo){

        var album = albumRepository.findById(idAlbum).get();
        album.getAmigos().add(clienteRepository.findById(idAmigo).get());
//        album.setCatalogo(dropBoxService.criarNovoCatalogo());
//        return albumRepository.save(album);
        return albumRepository.save(album);
    }
}
