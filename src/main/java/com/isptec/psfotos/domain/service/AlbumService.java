package com.isptec.psfotos.domain.service;

import com.isptec.psfotos.domain.entity.Album;
import com.isptec.psfotos.domain.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final DropBoxService dropBoxService;

    public Album novoAlbum(Album album){


        dropBoxService
        //TODO: salvar catalogo no dbx
        return albumRepository.save(album);
    }
}
