package br.com.guilhermevieira.financas.repository;

import br.com.guilhermevieira.financas.model.Lancamento;
import br.com.guilhermevieira.financas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LancamentoRepository extends JpaRepository<Lancamento, UUID> {

    List<Lancamento> findByUsuario(Usuario usuario0);

}
