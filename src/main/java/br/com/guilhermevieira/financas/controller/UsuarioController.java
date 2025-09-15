package br.com.guilhermevieira.financas.controller;

import br.com.guilhermevieira.financas.dto.UsuarioRequestDTO;
import br.com.guilhermevieira.financas.dto.UsuarioResponseDTO;
import br.com.guilhermevieira.financas.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criarUsuario(@RequestBody @Valid UsuarioRequestDTO requestDTO) {
        var usuarioSalvo = usuarioService.criarUsuario(requestDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuarioSalvo.id())
                .toUri();

        return ResponseEntity.created(location).body(usuarioSalvo);
    }



}
