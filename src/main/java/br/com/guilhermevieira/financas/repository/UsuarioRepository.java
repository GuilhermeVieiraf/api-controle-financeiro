package br.com.guilhermevieira.financas.repository;

import br.com.guilhermevieira.financas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
