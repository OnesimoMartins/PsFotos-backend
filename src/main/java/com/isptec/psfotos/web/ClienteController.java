package com.isptec.psfotos.web;

import com.isptec.psfotos.domain.entity.Album;
import com.isptec.psfotos.domain.entity.Cliente;
import com.isptec.psfotos.domain.repository.AlbumRepository;
import com.isptec.psfotos.domain.repository.ClienteRepository;
import com.isptec.psfotos.domain.service.ClienteService;
import com.isptec.psfotos.web.dto.ClienteDto;
import com.isptec.psfotos.web.dto.LoginDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Album> getClienteAlbuns(@PathVariable Integer id){
        return albumRepository.findAlbumByClienteId(id);
    }

    @GetMapping("{id}/amigos")
    public List<Cliente> getAmigos(@PathVariable Integer id,
                                   @RequestParam(value = "search",
                                   required = false) String search
    ){
//        var searc= new ApiSearchFilter(search);
        return clienteRepository.findAmigos(id);
    }

    @PutMapping("{id1}/conectar/{id2}")
    public Boolean conectarAmigos(@PathVariable Integer id1,@PathVariable Integer id2){
        return clienteService.conectarAmigos(id1,id2);
    }

    @GetMapping("{id}/nao-amigos")
    public List<Cliente> getNaoAmigos(@PathVariable  Integer id){
        return clienteRepository.findNotAmigos(id);
    }

    @PostMapping
    public ResponseEntity<?> criarCliente(@RequestBody @Valid ClienteDto dto){

        try {

            return ResponseEntity.ok().body(clienteService.criarCliente(
                    Cliente.builder()
                            .id(null)
                            .password(dto.getPassword())
                            .nome(dto.getNome())
                            .email(dto.getEmail())
                            .build())
            );
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
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
