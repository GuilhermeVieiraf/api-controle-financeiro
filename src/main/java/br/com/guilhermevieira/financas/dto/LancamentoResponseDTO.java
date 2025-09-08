package br.com.guilhermevieira.financas.dto;

import br.com.guilhermevieira.financas.model.enums.TipoLancamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record LancamentoResponseDTO(
        UUID id,
        String descricao,
        BigDecimal valor,
        TipoLancamento tipo,
        LocalDate data,
        String categoria
) {
}
