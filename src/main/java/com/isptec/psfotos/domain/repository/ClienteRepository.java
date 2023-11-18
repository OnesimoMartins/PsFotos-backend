package com.isptec.psfotos.domain.repository;

import com.isptec.psfotos.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    Optional<Cliente> findByEmailAndPassword(String email,String password );
}
