package com.isptec.psfotos.domain.service;

import com.isptec.psfotos.domain.entity.Cliente;
import com.isptec.psfotos.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public final Cliente criarCliente(Cliente c){
        return clienteRepository.save(c);
    }

    public final Cliente autenticar(Cliente c){
        return clienteRepository.findByEmailAndPassword(c.getEmail(),c.getPassword())
                .orElseThrow(()->new EntityNotFoundException("Nao encontrado"));
    }
}
