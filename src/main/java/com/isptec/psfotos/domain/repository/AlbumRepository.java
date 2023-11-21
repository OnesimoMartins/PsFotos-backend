package com.isptec.psfotos.domain.repository;

import com.isptec.psfotos.domain.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album,Integer> {

    @Query(value = "SELECT a.* FROM album a where a.id_cliente=:id", nativeQuery = true)
    List<Album> findAlbumByClienteId(@Param("id") Integer clienteId);

}
