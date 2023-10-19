package com.isptec.psfotos.domain.domain.service;

import com.isptec.psfotos.domain.domain.entity.Album;
import com.isptec.psfotos.domain.domain.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;

    public Album novoAlbum(Album album){
        return albumRepository.save(album);
    }
}
