package com.isptec.psfotos.web;

import com.isptec.psfotos.domain.entity.Album;
import com.isptec.psfotos.domain.entity.Cliente;
import com.isptec.psfotos.domain.repository.AlbumRepository;
import com.isptec.psfotos.domain.repository.ClienteRepository;
import com.isptec.psfotos.domain.service.ClienteService;
import com.isptec.psfotos.web.dto.ClienteDto;
import com.isptec.psfotos.web.dto.LoginDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("clientes")
@RestController
@AllArgsConstructor
public class ClienteController {

    private final AlbumRepository albumRepository;
    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;

    @GetMapping("{id}/albums")
    public List<Album> getClienteAlbuns(Integer id){
        return albumRepository.findAlbumByClienteId(id);
    }


    @GetMapping("{id}/amigos")
    public List<Cliente> getAmigos(@PathVariable Integer id){
        return clienteRepository.findAmigos(id);
    }

    @GetMapping("{id}/nao-amigos")
    public List<Cliente> getNaoAmigos(@PathVariable  Integer id){
        return clienteRepository.findNotAmigos(id);
    }

    @PostMapping
    public Cliente criarCliente(@RequestBody @Valid ClienteDto dto){

        return clienteService.criarCliente(
                Cliente.builder()
                        .id(null)
                        .password(dto.getPassword())
                        .nome(dto.getNome())
                        .email(dto.getEmail())
                        .build()
        );
    }

    @PostMapping("/login")
    public Cliente login(@RequestBody @Valid LoginDto dto){

        return clienteService.autenticar(
                Cliente.builder()
                        .password(dto.getPassword())
                        .email(dto.getEmail())
                        .build()
        );
    }




}
