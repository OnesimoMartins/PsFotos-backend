package com.isptec.psfotos.domain.repository;

import com.isptec.psfotos.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    Optional<Cliente> findByEmailAndPassword(String email,String password );
    Optional<Cliente> findByEmail(String email);

    @Query(
            nativeQuery = true,
            value = "select * from cliente c " +
                    "inner join cliente_amigos ca on " +
                    "    ca.cliente= c.id or ca.cliente2= c.id " +
                    "where (ca.cliente=:id or ca.cliente2=:id) and c.id !=:id"
    )
    List<Cliente> findAmigos(@Param("id") Integer id);


    @Query(
            nativeQuery = true,
            value =  "  select * from cliente c" +
                    "    left join cliente_amigos ca on  ca.cliente = c.id or ca.cliente2= c.id " +
                    "     where c.id!= :id and (  (ca.cliente!= :id and ca.cliente2!= :id) or " +
                    "                          (ca.cliente is null and ca.cliente2 is null) " +
                    "         )"
    )
    List<Cliente> findNotAmigos( @Param("id") Integer id);
}
