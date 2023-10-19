package com.isptec.psfotos.domain.domain.repository;

import com.isptec.psfotos.domain.domain.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Album,Integer> {
}
