package com.isptec.psfotos.web;

import com.isptec.psfotos.domain.entity.Album;
import com.isptec.psfotos.domain.entity.Cliente;
import com.isptec.psfotos.domain.repository.AlbumRepository;
import com.isptec.psfotos.domain.service.ClienteService;
import com.isptec.psfotos.web.dto.ClienteDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("{id}/albums")
    public List<Album> getClienteAlbuns(Integer id){
        return albumRepository.findAlbumByClienteId(id);
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


}
