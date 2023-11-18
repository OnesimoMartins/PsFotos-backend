package com.isptec.psfotos.domain.repository;

import com.isptec.psfotos.domain.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album,Integer> {
    List<Album> findAlbumByClienteId(Integer id);
}
