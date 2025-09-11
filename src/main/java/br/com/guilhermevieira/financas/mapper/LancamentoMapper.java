package br.com.guilhermevieira.financas.mapper;

import br.com.guilhermevieira.financas.dto.LancamentoRequestDTO;
import br.com.guilhermevieira.financas.dto.LancamentoResponseDTO;
import br.com.guilhermevieira.financas.model.Lancamento;
import br.com.guilhermevieira.financas.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LancamentoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "data", expression = "java(java.time.LocalDate.now())")
    Lancamento toEntity(LancamentoRequestDTO dto, Usuario usuario);
    LancamentoResponseDTO toResponseDTO(Lancamento entity);
}
