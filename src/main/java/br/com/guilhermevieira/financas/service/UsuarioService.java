package br.com.guilhermevieira.financas.service;

import br.com.guilhermevieira.financas.dto.UsuarioRequestDTO;
import br.com.guilhermevieira.financas.dto.UsuarioResponseDTO;
import br.com.guilhermevieira.financas.mapper.UsuarioMapper;
import br.com.guilhermevieira.financas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO requestDTO) {
        var usuario = usuarioMapper.toEntity(requestDTO);
        var usuarioSalvo = usuarioRepository.save(usuario);
        return usuarioMapper.toResponseDTO(usuarioSalvo);
    }


}
