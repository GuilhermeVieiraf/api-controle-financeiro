package br.com.guilhermevieira.financas.mapper;

import br.com.guilhermevieira.financas.dto.UsuarioRequestDTO;
import br.com.guilhermevieira.financas.dto.UsuarioResponseDTO;
import br.com.guilhermevieira.financas.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioRequestDTO dto);
    UsuarioResponseDTO toResponseDTO(Usuario entity);

}
