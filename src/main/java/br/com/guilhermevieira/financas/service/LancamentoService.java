package br.com.guilhermevieira.financas.service;

import br.com.guilhermevieira.financas.dto.LancamentoRequestDTO;
import br.com.guilhermevieira.financas.dto.LancamentoResponseDTO;
import br.com.guilhermevieira.financas.model.Lancamento;
import br.com.guilhermevieira.financas.model.Usuario;
import br.com.guilhermevieira.financas.repository.LancamentoRepository;
import br.com.guilhermevieira.financas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LancamentoService {

    private final LancamentoRepository lancamentoRepository;
    private final UsuarioRepository usuarioRepository;

    public LancamentoResponseDTO criarLancamento(UUID usuarioId, LancamentoRequestDTO requestDTO) {
        var usuarioOptional = usuarioRepository.findById(usuarioId);
        var usuario = usuarioOptional.orElseThrow(() -> new RuntimeException("Usuário não econtrado!"));

        var lancamento = new Lancamento();
        lancamento.setDescricao(requestDTO.descricao());
        lancamento.setValor(requestDTO.valor());
        lancamento.setTipo(requestDTO.tipo());
        lancamento.setCategoria(requestDTO.categoria());
        lancamento.setData(requestDTO.data());
        lancamento.setUsuario(usuario);

        var lancamentoSalvo = lancamentoRepository.save(lancamento);

        return new LancamentoResponseDTO(
                lancamentoSalvo.getId(),
                lancamentoSalvo.getDescricao(),
                lancamentoSalvo.getValor(),
                lancamentoSalvo.getTipo(),
                lancamentoSalvo.getData(),
                lancamentoSalvo.getCategoria()
        );

    }

}
