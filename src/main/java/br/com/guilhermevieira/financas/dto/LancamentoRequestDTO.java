package br.com.guilhermevieira.financas.dto;

import br.com.guilhermevieira.financas.model.enums.TipoLancamento;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record LancamentoRequestDTO(
        @NotBlank(message = "Descrição não pode ser vazia.")
        String descricao,
        @NotNull(message = "Valor não pode ser nulo.")
        @DecimalMin(value = "0.01", message = "Valor deve ser maior que zero.")
        BigDecimal valor,
        @NotNull(message = "Tipo não pode ser nulo.")
        TipoLancamento tipo,
        @NotBlank(message = "Categoria não pode ser vazia.")
        String categoria
) {
}
