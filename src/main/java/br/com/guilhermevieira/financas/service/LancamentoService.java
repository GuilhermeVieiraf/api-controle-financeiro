package br.com.guilhermevieira.financas.service;

import br.com.guilhermevieira.financas.dto.LancamentoRequestDTO;
import br.com.guilhermevieira.financas.dto.LancamentoResponseDTO;
import br.com.guilhermevieira.financas.mapper.LancamentoMapper;
import br.com.guilhermevieira.financas.repository.LancamentoRepository;
import br.com.guilhermevieira.financas.repository.UsuarioRepository;
import br.com.guilhermevieira.financas.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LancamentoService {

    private final LancamentoRepository lancamentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final LancamentoMapper lancamentoMapper;
    public LancamentoResponseDTO criarLancamento(UUID usuarioId, LancamentoRequestDTO requestDTO) {

        var usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));

        var lancamento = lancamentoMapper.toEntity(requestDTO, usuario);
        var lancamentoSalvo = lancamentoRepository.save(lancamento);
        return lancamentoMapper.toResponseDTO(lancamentoSalvo);

    }

}
