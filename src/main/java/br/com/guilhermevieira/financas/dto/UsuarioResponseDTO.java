package br.com.guilhermevieira.financas.dto;

import java.util.UUID;

public record UsuarioResponseDTO(
        UUID id,
        String nome,
        String email
) {
}
