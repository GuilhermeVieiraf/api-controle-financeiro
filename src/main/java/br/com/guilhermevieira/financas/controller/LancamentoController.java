package br.com.guilhermevieira.financas.controller;

import br.com.guilhermevieira.financas.dto.LancamentoRequestDTO;
import br.com.guilhermevieira.financas.dto.LancamentoResponseDTO;
import br.com.guilhermevieira.financas.service.LancamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class LancamentoController {

    private final LancamentoService lancamentoService;

    @PostMapping("/{usuarioId}/lancamentos")
    public ResponseEntity<LancamentoResponseDTO> criarLancamento(@PathVariable UUID usuarioId,
                                                                 @RequestBody @Valid LancamentoRequestDTO requestDTO) {

        var lancamentoSalvo = lancamentoService.criarLancamento(usuarioId, requestDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(lancamentoSalvo.id())
                .toUri();

        return ResponseEntity.created(location).body(lancamentoSalvo);

    }
}
