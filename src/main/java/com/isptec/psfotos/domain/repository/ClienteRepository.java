package com.isptec.psfotos.domain.repository;

import com.isptec.psfotos.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
