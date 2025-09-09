package br.com.guilhermevieira.financas.service;

import br.com.guilhermevieira.financas.dto.UsuarioRequestDTO;
import br.com.guilhermevieira.financas.dto.UsuarioResponseDTO;
import br.com.guilhermevieira.financas.model.Usuario;
import br.com.guilhermevieira.financas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO requestDTO) {
        var usuario = new Usuario();
        usuario.setNome(requestDTO.nome());
        usuario.setEmail(requestDTO.email());
        usuario.setSenha(requestDTO.senha());

        var usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioResponseDTO(
                usuarioSalvo.getId(),
                usuarioSalvo.getNome(),
                usuarioSalvo.getEmail()
        );
    }


}
