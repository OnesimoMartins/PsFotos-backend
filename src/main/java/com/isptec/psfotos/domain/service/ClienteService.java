package com.isptec.psfotos.domain.service;

import com.isptec.psfotos.domain.entity.Cliente;
import com.isptec.psfotos.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final EntityManager entityManager;

    public final Cliente criarCliente(Cliente c){
        return clienteRepository.save(c);
    }

    public final Cliente autenticar(Cliente c){
        return clienteRepository.findByEmailAndPassword(c.getEmail(),c.getPassword())
                .orElse(null);
    }

    public final Boolean conectarAmigos(Integer id1, Integer id2){
       Optional<Cliente> c = clienteRepository.findAmigos(id1)
               .stream().filter(it->
                       Objects.equals(it.getId(),id2)
                   ).findFirst();

       if (c.isPresent()) return false;

       String sql = String.format(
               "insert into cliente_amigos(cliente,cliente2) values (%s,%s);",
               id1,id2
       );
       int rows = entityManager.createQuery(sql).executeUpdate();
        return rows > 0;
    }

}
